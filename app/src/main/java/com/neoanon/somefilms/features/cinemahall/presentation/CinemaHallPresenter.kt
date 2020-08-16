package com.neoanon.somefilms.features.cinemahall.presentation

import com.neoanon.somefilms.features.cinemahall.presentation.converter.FilmInfoItemsConverter
import com.neoanon.somefilms.shared.films.domain.usecase.GetGenresUseCase
import com.neoanon.somefilms.shared.films.domain.usecase.GetSelectedGenreIdUseCase
import com.neoanon.somefilms.shared.films.domain.usecase.GetSortedPostersUseCase
import com.neoanon.somefilms.shared.films.domain.usecase.SetSelectedGenreIdUseCase
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope

class CinemaHallPresenter(
	private val getSortedPostersUseCase: GetSortedPostersUseCase,
	private val getGenresUseCase: GetGenresUseCase,
	private val setSelectedGenreIdUseCase: SetSelectedGenreIdUseCase,
	private val getSelectedGenreIdUseCase: GetSelectedGenreIdUseCase,
	private val filmInfoItemsConverter: FilmInfoItemsConverter,
	private val router: CinemaHallRouter
) : MvpPresenter<CinemaHallView>() {

	private var clickable: Boolean = true

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()
		loadPostersWithGenres()
	}

	fun onGenreItemClicked(selectedGenreId: Long) {
		if (!clickable) {
			return
		}
		setSelectedGenreIdUseCase(selectedGenreId)
		loadPostersWithGenres()
	}

	fun onPosterItemClicked(selectedPosterId: Long) {
		if (!clickable) {
			return
		}
		router.navigateToDetailFilm(selectedPosterId)
	}

	fun onRefresh() {
		loadPostersWithGenres(refresh = true)
	}

	private fun loadPostersWithGenres(refresh: Boolean = false) {
		presenterScope.launch {
			runCatching {
				clickable = false
				viewState.showProgress()

				val filmInfoEntities = FilmInfoEntities(
					posters = getSortedPostersUseCase(refresh),
					genres = getGenresUseCase(),
					selectedGenreId = getSelectedGenreIdUseCase()
				)
				val filmInfoItems = filmInfoItemsConverter.convert(filmInfoEntities)
				viewState.hideProgress()
				viewState.showFilmInfoList(filmInfoItems)
				clickable = true
			}
				.onFailure {
					clickable = true
					viewState.hideProgress()
					viewState.showErrorInfo()
				}
		}
	}

	fun onBackClicked() {
		router.exit()
	}
}
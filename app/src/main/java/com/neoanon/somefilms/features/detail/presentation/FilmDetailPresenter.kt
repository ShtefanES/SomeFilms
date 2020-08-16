package com.neoanon.somefilms.features.detail.presentation

import com.neoanon.somefilms.shared.films.domain.usecase.GetFilmDetailUseCase
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope

class FilmDetailPresenter(
	private val getFilmDetailUseCase: GetFilmDetailUseCase,
	private val router: FilmDetailRouter
) : MvpPresenter<FilmDetailView>() {

	fun onFilmIdFetched(filmId: Long) {
		presenterScope.launch {
			runCatching {
				val filmDetail = getFilmDetailUseCase(filmId)
				viewState.showFilmDetail(filmDetail)
			}
				.onFailure {
					viewState.showErrorInfo()
				}
		}
	}

	fun onBackClicked() {
		router.close()
	}
}
package com.neoanon.somefilms.shared.films.data.repository

import com.neoanon.somefilms.shared.films.data.converter.FilmInfoListConverter
import com.neoanon.somefilms.shared.films.data.converter.FilmToGenreListConverter
import com.neoanon.somefilms.shared.films.data.converter.GenreInfoListConverter
import com.neoanon.somefilms.shared.films.data.converter.PosterListConverter
import com.neoanon.somefilms.shared.films.data.datasource.CacheDateDataSource
import com.neoanon.somefilms.shared.films.data.datasource.FilmsLocalDataSource
import com.neoanon.somefilms.shared.films.data.datasource.FilmsRemoteDataSource
import com.neoanon.somefilms.shared.films.data.datasource.SelectedGenreIdDataSource
import com.neoanon.somefilms.shared.films.data.model.FilmModel
import com.neoanon.somefilms.shared.films.domain.entity.Poster
import com.neoanon.somefilms.shared.films.domain.repository.PostersRepository

class PostersRepositoryImpl(
	private val cacheDateDataSource: CacheDateDataSource,
	private val filmsLocalDataSource: FilmsLocalDataSource,
	private val filmsRemoteDataSource: FilmsRemoteDataSource,
	private val selectedGenreIdDataSource: SelectedGenreIdDataSource,
	private val filmInfoListConverter: FilmInfoListConverter,
	private val genreInfoListConverter: GenreInfoListConverter,
	private val filmToGenreListConverter: FilmToGenreListConverter,
	private val posterListConverter: PosterListConverter
) : PostersRepository {

	override suspend fun get(refresh: Boolean): List<Poster> {
		val shouldRefreshData = refresh || cacheDateDataSource.isCacheDirty()

		if (shouldRefreshData) {
			filmsLocalDataSource.clearFilmsAnGenres()
			val newFilmModels = filmsRemoteDataSource.get().films
			updateLocalFilmsInfo(newFilmModels)
			cacheDateDataSource.updateDirtyCacheDate()
		}

		val films = getLocalFilms(selectedGenreIdDataSource.get())
		return posterListConverter.convert(films)
	}

	private suspend fun updateLocalFilmsInfo(filmModels: List<FilmModel>) {
		val listOfFilmInfo = filmInfoListConverter.convert(filmModels)
		val listOfGenreInfo = genreInfoListConverter.convert(filmModels)
		val listOfFilmToGenre = filmToGenreListConverter.convert(Pair(filmModels, listOfGenreInfo))

		filmsLocalDataSource.saveFilmsAnGenres(
			films = listOfFilmInfo,
			genres = listOfGenreInfo,
			filmsToGenre = listOfFilmToGenre
		)
	}

	private suspend fun getLocalFilms(selectedGenreId: Long?) =
		selectedGenreId?.let { id ->
			filmsLocalDataSource.getFilmsByGenreId(id)
		} ?: filmsLocalDataSource.getFilms()
}
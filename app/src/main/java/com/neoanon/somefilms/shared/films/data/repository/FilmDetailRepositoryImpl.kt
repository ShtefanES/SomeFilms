package com.neoanon.somefilms.shared.films.data.repository

import com.neoanon.somefilms.shared.films.data.converter.FilmDetailConverter
import com.neoanon.somefilms.shared.films.data.datasource.FilmsLocalDataSource
import com.neoanon.somefilms.shared.films.domain.entity.FilmDetail
import com.neoanon.somefilms.shared.films.domain.repository.FilmDetailRepository

class FilmDetailRepositoryImpl(
	private val filmsLocalDataSource: FilmsLocalDataSource,
	private val filmDetailConverter: FilmDetailConverter
) : FilmDetailRepository {

	override suspend fun get(id: Long): FilmDetail {
		val filmInfo = filmsLocalDataSource.getFilms(id)
		return filmDetailConverter.convert(filmInfo)
	}
}
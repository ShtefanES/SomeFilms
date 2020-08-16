package com.neoanon.somefilms.shared.films.data.repository

import com.neoanon.somefilms.shared.films.data.converter.GenreListConverter
import com.neoanon.somefilms.shared.films.data.datasource.FilmsLocalDataSource
import com.neoanon.somefilms.shared.films.domain.entity.Genre
import com.neoanon.somefilms.shared.films.domain.repository.GenresRepository

class GenresRepositoryImpl(private val filmsLocalDataSource: FilmsLocalDataSource,
						   private val genreListConverter: GenreListConverter) : GenresRepository {

	override suspend fun get(): List<Genre> {
		val genresInfoList = filmsLocalDataSource.getGenres()
		return genreListConverter.convert(genresInfoList)
	}
}
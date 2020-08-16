package com.neoanon.somefilms.shared.films.data.repository

import com.neoanon.somefilms.shared.films.data.datasource.SelectedGenreIdDataSource
import com.neoanon.somefilms.shared.films.domain.repository.SelectedGenreIdRepository

class SelectedGenreIdRepositoryImpl(private val selectedGenreIdDataSource: SelectedGenreIdDataSource) : SelectedGenreIdRepository {

	override fun set(genreId: Long) {
		selectedGenreIdDataSource.set(genreId)
	}

	override fun get(): Long? =
		selectedGenreIdDataSource.get()
}
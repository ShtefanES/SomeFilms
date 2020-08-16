package com.neoanon.somefilms.shared.films.domain.repository

interface SelectedGenreIdRepository {

	fun set(genreId: Long)

	fun get(): Long?
}
package com.neoanon.somefilms.shared.films.data.datasource

interface SelectedGenreIdDataSource {

	fun set(genreId: Long)

	fun get(): Long?

	fun clear()
}

class SelectedGenreIdDataSourceImpl() : SelectedGenreIdDataSource {

	private var selectedGenreId: Long? = null

	override fun set(genreId: Long) {
		if (genreId == selectedGenreId) {
			clear()
		} else {
			selectedGenreId = genreId
		}
	}

	override fun get(): Long? =
		selectedGenreId

	override fun clear() {
		selectedGenreId = null
	}
}
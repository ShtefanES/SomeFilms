package com.neoanon.somefilms.shared.films.data.converter

import com.neoanon.somefilms.shared.films.data.db.GenreInfo
import com.neoanon.somefilms.shared.films.data.model.FilmModel

class GenreInfoListConverter {

	fun convert(from: List<FilmModel>): List<GenreInfo> {
		val setOfGenres = HashSet<String>()
		from.forEach { setOfGenres.addAll(it.genres) }

		val listOfGenres = setOfGenres.toList()
		val sortedListOfGenres = listOfGenres.sorted()

		val listOfGenreInfo = ArrayList<GenreInfo>()
		sortedListOfGenres.forEachIndexed { index, value ->
			listOfGenreInfo.add(GenreInfo(index.toLong(), value))
		}
		return listOfGenreInfo
	}
}
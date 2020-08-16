package com.neoanon.somefilms.shared.films.data.converter

import com.neoanon.somefilms.shared.films.data.db.FilmToGenre
import com.neoanon.somefilms.shared.films.data.db.GenreInfo
import com.neoanon.somefilms.shared.films.data.model.FilmModel

class FilmToGenreListConverter {

	fun convert(from: Pair<List<FilmModel>, List<GenreInfo>>): List<FilmToGenre> {
		val (films, genreInfoList) = from
		val genreToIndexes = HashMap<String, Long>()
		genreInfoList.forEach { genreToIndexes[it.name] = it.id }

		val filmToGenreList = ArrayList<FilmToGenre>()
		films.forEach { filmModel ->
			filmModel.genres.forEach loop@{ genre ->
				val genreIndex = genreToIndexes[genre] ?: return@loop
				val filmIndex = filmModel.id
				filmToGenreList.add(FilmToGenre(filmId = filmIndex, genreId = genreIndex))
			}
		}
		return filmToGenreList
	}
}
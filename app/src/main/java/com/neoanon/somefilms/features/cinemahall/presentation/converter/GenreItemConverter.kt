package com.neoanon.somefilms.features.cinemahall.presentation.converter

import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem.GenreItem
import com.neoanon.somefilms.shared.films.domain.entity.Genre

class GenreItemConverter {

	fun convert(from: Pair<Genre, Long?>): GenreItem {
		val (genre, selectedGenreId) = from

		val selected = selectedGenreId?.let { it == genre.id } ?: false

		return GenreItem(id = genre.id,
						 name = genre.name,
						 selected = selected)
	}
}
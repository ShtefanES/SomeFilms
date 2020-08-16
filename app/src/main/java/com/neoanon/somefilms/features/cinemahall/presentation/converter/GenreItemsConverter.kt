package com.neoanon.somefilms.features.cinemahall.presentation.converter

import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem.GenreItem
import com.neoanon.somefilms.shared.films.domain.entity.Genre

class GenreItemsConverter(private val genreItemConverter: GenreItemConverter) {

	fun convert(from: Pair<List<Genre>, Long?>): List<GenreItem> {
		val (genres, selectedGenreId) = from
		return genres.map { genreItemConverter.convert(Pair(it, selectedGenreId)) }
	}
}
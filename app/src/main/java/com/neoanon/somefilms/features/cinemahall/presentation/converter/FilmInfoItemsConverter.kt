package com.neoanon.somefilms.features.cinemahall.presentation.converter

import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoEntities
import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem
import com.neoanon.somefilms.features.cinemahall.presentation.GENRE_TITLE_ID
import com.neoanon.somefilms.features.cinemahall.presentation.POSTER_TITLE_ID
import com.neoanon.somefilms.features.cinemahall.presentation.TitleType

class FilmInfoItemsConverter(
	private val genreItemsConverter: GenreItemsConverter,
	private val posterItemsConverter: PosterItemsConverter
) {

	fun convert(from: FilmInfoEntities): List<FilmInfoItem> {
		val genres = from.genres
		val posters = from.posters
		val selectedGenreId = from.selectedGenreId

		return ArrayList<FilmInfoItem>().apply {
			add(FilmInfoItem.TitleItem(GENRE_TITLE_ID, TitleType.GENRE))
			addAll(genreItemsConverter.convert(Pair(genres, selectedGenreId)))
			add(FilmInfoItem.TitleItem(POSTER_TITLE_ID, TitleType.POSTER))
			addAll(posterItemsConverter.convert(posters))
		}
	}
}
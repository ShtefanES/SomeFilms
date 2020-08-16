package com.neoanon.somefilms.features.cinemahall.presentation.converter

import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem.PosterItem
import com.neoanon.somefilms.shared.films.domain.entity.Poster

class PosterItemsConverter(private val posterItemConverter: PosterItemConverter) {

	fun convert(posters: List<Poster>): List<PosterItem> =
		posters.map(posterItemConverter::convert)
}
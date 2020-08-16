package com.neoanon.somefilms.features.cinemahall.presentation.converter

import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem.PosterItem
import com.neoanon.somefilms.shared.films.domain.entity.Poster

class PosterItemConverter {

	fun convert(poster: Poster): PosterItem =
		PosterItem(id = poster.filmId,
				   title = poster.title,
				   imageUrl = poster.imageUrl)
}
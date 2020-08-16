package com.neoanon.somefilms.shared.films.data.converter

import com.neoanon.somefilms.shared.films.data.db.FilmInfo
import com.neoanon.somefilms.shared.films.domain.entity.Poster

class PosterConverter {

	fun convert(from: FilmInfo): Poster =
		Poster(filmId = from.id,
			   title = from.localizedName,
			   imageUrl = from.imageUrl)
}
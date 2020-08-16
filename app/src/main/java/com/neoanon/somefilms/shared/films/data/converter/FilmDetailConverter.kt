package com.neoanon.somefilms.shared.films.data.converter

import com.neoanon.somefilms.shared.films.data.db.FilmInfo
import com.neoanon.somefilms.shared.films.domain.entity.FilmDetail

class FilmDetailConverter {

	fun convert(from: FilmInfo): FilmDetail =
		FilmDetail(
			title = from.localizedName,
			originalTitle = from.name,
			imageUrl = from.imageUrl,
			year = from.year.toString(),
			rating = from.rating,
			description = from.description
		)
}
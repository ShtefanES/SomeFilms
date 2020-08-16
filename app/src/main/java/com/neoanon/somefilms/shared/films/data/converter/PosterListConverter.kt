package com.neoanon.somefilms.shared.films.data.converter

import com.neoanon.somefilms.shared.films.data.db.FilmInfo
import com.neoanon.somefilms.shared.films.domain.entity.Poster

class PosterListConverter(private val posterConverter: PosterConverter) {

	fun convert(from: List<FilmInfo>): List<Poster> =
		from.map(posterConverter::convert)
}
package com.neoanon.somefilms.shared.films.data.converter

import com.neoanon.somefilms.shared.films.data.db.GenreInfo
import com.neoanon.somefilms.shared.films.domain.entity.Genre

class GenreConverter {

	fun convert(from: GenreInfo): Genre =
		Genre(id = from.id,
			  name = from.name)
}
package com.neoanon.somefilms.shared.films.domain.repository

import com.neoanon.somefilms.shared.films.domain.entity.FilmDetail

interface FilmDetailRepository {

	suspend fun get(id: Long): FilmDetail
}
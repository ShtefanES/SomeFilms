package com.neoanon.somefilms.shared.films.domain.repository

import com.neoanon.somefilms.shared.films.domain.entity.Genre

interface GenresRepository {

	suspend fun get(): List<Genre>
}
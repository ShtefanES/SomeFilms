package com.neoanon.somefilms.shared.films.domain.repository

import com.neoanon.somefilms.shared.films.domain.entity.Poster

interface PostersRepository {

	suspend fun get(refresh: Boolean): List<Poster>
}
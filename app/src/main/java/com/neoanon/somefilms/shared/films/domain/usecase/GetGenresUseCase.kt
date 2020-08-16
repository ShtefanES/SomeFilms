package com.neoanon.somefilms.shared.films.domain.usecase

import com.neoanon.somefilms.shared.films.domain.entity.Genre
import com.neoanon.somefilms.shared.films.domain.repository.GenresRepository

class GetGenresUseCase(private val genresRepository: GenresRepository) {

	suspend operator fun invoke(): List<Genre> =
		genresRepository.get()
}
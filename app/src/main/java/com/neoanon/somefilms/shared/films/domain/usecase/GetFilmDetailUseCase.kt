package com.neoanon.somefilms.shared.films.domain.usecase

import com.neoanon.somefilms.shared.films.domain.repository.FilmDetailRepository

class GetFilmDetailUseCase(private val repository: FilmDetailRepository) {

	suspend operator fun invoke(id: Long) =
		repository.get(id)
}
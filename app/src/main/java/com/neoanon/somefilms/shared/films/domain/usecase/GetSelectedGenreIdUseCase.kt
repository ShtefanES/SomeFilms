package com.neoanon.somefilms.shared.films.domain.usecase

import com.neoanon.somefilms.shared.films.domain.repository.SelectedGenreIdRepository

class GetSelectedGenreIdUseCase(private val selectedGenreIdRepository: SelectedGenreIdRepository) {

	operator fun invoke(): Long? =
		selectedGenreIdRepository.get()
}
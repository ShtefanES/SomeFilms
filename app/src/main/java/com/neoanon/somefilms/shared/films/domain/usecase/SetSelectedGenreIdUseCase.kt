package com.neoanon.somefilms.shared.films.domain.usecase

import com.neoanon.somefilms.shared.films.domain.repository.SelectedGenreIdRepository

class SetSelectedGenreIdUseCase(private val selectedGenreIdRepository: SelectedGenreIdRepository) {

	operator fun invoke(selectedGenreId: Long) {
		selectedGenreIdRepository.set(selectedGenreId)
	}
}
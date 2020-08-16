package com.neoanon.somefilms.shared.films.domain.usecase

import com.neoanon.somefilms.shared.films.domain.entity.Poster
import com.neoanon.somefilms.shared.films.domain.repository.PostersRepository

class GetSortedPostersUseCase(private val postersRepository: PostersRepository) {

	suspend operator fun invoke(refresh: Boolean = false): List<Poster> =
		postersRepository.get(refresh)
			.sortedBy { it.title }
}
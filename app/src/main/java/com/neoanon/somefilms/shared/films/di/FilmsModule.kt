package com.neoanon.somefilms.shared.films.di

import com.neoanon.somefilms.shared.films.data.converter.FilmDetailConverter
import com.neoanon.somefilms.shared.films.data.converter.FilmInfoConverter
import com.neoanon.somefilms.shared.films.data.converter.FilmInfoListConverter
import com.neoanon.somefilms.shared.films.data.converter.FilmToGenreListConverter
import com.neoanon.somefilms.shared.films.data.converter.GenreConverter
import com.neoanon.somefilms.shared.films.data.converter.GenreInfoListConverter
import com.neoanon.somefilms.shared.films.data.converter.GenreListConverter
import com.neoanon.somefilms.shared.films.data.converter.PosterConverter
import com.neoanon.somefilms.shared.films.data.converter.PosterListConverter
import com.neoanon.somefilms.shared.films.data.datasource.CacheDateDataSource
import com.neoanon.somefilms.shared.films.data.datasource.CacheDateDataSourceImpl
import com.neoanon.somefilms.shared.films.data.datasource.FilmsLocalDataSource
import com.neoanon.somefilms.shared.films.data.datasource.FilmsLocalDataSourceImpl
import com.neoanon.somefilms.shared.films.data.datasource.FilmsRemoteDataSource
import com.neoanon.somefilms.shared.films.data.datasource.FilmsRemoteDataSourceImpl
import com.neoanon.somefilms.shared.films.data.datasource.SelectedGenreIdDataSource
import com.neoanon.somefilms.shared.films.data.datasource.SelectedGenreIdDataSourceImpl
import com.neoanon.somefilms.shared.films.data.preferences.Preferences
import com.neoanon.somefilms.shared.films.data.preferences.PreferencesImpl
import com.neoanon.somefilms.shared.films.data.repository.FilmDetailRepositoryImpl
import com.neoanon.somefilms.shared.films.data.repository.GenresRepositoryImpl
import com.neoanon.somefilms.shared.films.data.repository.PostersRepositoryImpl
import com.neoanon.somefilms.shared.films.data.repository.SelectedGenreIdRepositoryImpl
import com.neoanon.somefilms.shared.films.domain.repository.FilmDetailRepository
import com.neoanon.somefilms.shared.films.domain.repository.GenresRepository
import com.neoanon.somefilms.shared.films.domain.repository.PostersRepository
import com.neoanon.somefilms.shared.films.domain.repository.SelectedGenreIdRepository
import com.neoanon.somefilms.shared.films.domain.usecase.GetFilmDetailUseCase
import com.neoanon.somefilms.shared.films.domain.usecase.GetGenresUseCase
import com.neoanon.somefilms.shared.films.domain.usecase.GetSelectedGenreIdUseCase
import com.neoanon.somefilms.shared.films.domain.usecase.GetSortedPostersUseCase
import com.neoanon.somefilms.shared.films.domain.usecase.SetSelectedGenreIdUseCase
import org.koin.dsl.module

val filmsModule = module {
	single<FilmsRemoteDataSource> { FilmsRemoteDataSourceImpl(get()) }
	single<FilmsLocalDataSource> { FilmsLocalDataSourceImpl(get()) }
	single<CacheDateDataSource> { CacheDateDataSourceImpl(get()) }
	single<SelectedGenreIdDataSource> { SelectedGenreIdDataSourceImpl() }

	single<Preferences> { PreferencesImpl(get()) }

	factory { FilmInfoListConverter(get()) }
	factory { FilmInfoConverter() }
	factory { GenreInfoListConverter() }
	factory { FilmToGenreListConverter() }
	factory { PosterListConverter(get()) }
	factory { PosterConverter() }
	factory { FilmDetailConverter() }

	factory { GenreListConverter(get()) }
	factory { GenreConverter() }

	single<PostersRepository> { PostersRepositoryImpl(get(), get(), get(), get(), get(), get(), get(), get()) }
	single<GenresRepository> { GenresRepositoryImpl(get(), get()) }
	single<SelectedGenreIdRepository> { SelectedGenreIdRepositoryImpl(get()) }
	single<FilmDetailRepository> { FilmDetailRepositoryImpl(get(), get()) }

	factory { GetSortedPostersUseCase(get()) }
	factory { GetGenresUseCase(get()) }
	factory { SetSelectedGenreIdUseCase(get()) }
	factory { GetSelectedGenreIdUseCase(get()) }
	factory { GetFilmDetailUseCase(get()) }
}
package com.neoanon.somefilms.features.cinemahall.di

import com.neoanon.somefilms.features.cinemahall.presentation.CinemaHallPresenter
import com.neoanon.somefilms.features.cinemahall.presentation.converter.FilmInfoItemsConverter
import com.neoanon.somefilms.features.cinemahall.presentation.converter.GenreItemConverter
import com.neoanon.somefilms.features.cinemahall.presentation.converter.GenreItemsConverter
import com.neoanon.somefilms.features.cinemahall.presentation.converter.PosterItemConverter
import com.neoanon.somefilms.features.cinemahall.presentation.converter.PosterItemsConverter
import org.koin.dsl.module

val cinemaHallModule = module {
	factory { CinemaHallPresenter(get(), get(), get(), get(), get(), get()) }

	factory { PosterItemsConverter(get()) }
	factory { PosterItemConverter() }

	factory { FilmInfoItemsConverter(get(), get()) }

	factory { GenreItemsConverter(get()) }
	factory { GenreItemConverter() }
}
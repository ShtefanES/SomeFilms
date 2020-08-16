package com.neoanon.somefilms.shared.films.data.datasource

import com.neoanon.somefilms.shared.films.data.model.RootFilmsModel
import com.neoanon.somefilms.shared.films.data.network.FilmApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface FilmsRemoteDataSource {

suspend fun get(): RootFilmsModel
}

class FilmsRemoteDataSourceImpl(private val filmApi: FilmApi) : FilmsRemoteDataSource {

    override suspend fun get(): RootFilmsModel =
        withContext(Dispatchers.IO) {
            filmApi.getFilms()
        }
}
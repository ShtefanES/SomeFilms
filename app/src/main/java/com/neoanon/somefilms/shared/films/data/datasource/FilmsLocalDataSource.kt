package com.neoanon.somefilms.shared.films.data.datasource

import com.neoanon.somefilms.shared.films.data.db.AppDatabase
import com.neoanon.somefilms.shared.films.data.db.FilmInfo
import com.neoanon.somefilms.shared.films.data.db.FilmToGenre
import com.neoanon.somefilms.shared.films.data.db.GenreInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface FilmsLocalDataSource {

	suspend fun getFilms(): List<FilmInfo>

	suspend fun getFilms(id: Long): FilmInfo

	suspend fun getGenres(): List<GenreInfo>

	suspend fun getFilmsByGenreId(genreId: Long): List<FilmInfo>

	suspend fun saveFilmsAnGenres(films: List<FilmInfo>,
								  genres: List<GenreInfo>,
								  filmsToGenre: List<FilmToGenre>)

	suspend fun clearFilmsAnGenres()
}

class FilmsLocalDataSourceImpl(private val database: AppDatabase) : FilmsLocalDataSource {

	override suspend fun getFilms(): List<FilmInfo> =
		withContext(Dispatchers.IO) {
			database.filmWithGenresDao().selectFilms()
		}

	override suspend fun getFilms(id: Long): FilmInfo =
		withContext(Dispatchers.IO) {
			database.filmWithGenresDao().selectFilmById(id)
		}

	override suspend fun getGenres(): List<GenreInfo> =
		withContext(Dispatchers.IO) {
			database.filmWithGenresDao().selectGenres()
		}

	override suspend fun getFilmsByGenreId(genreId: Long): List<FilmInfo> =
		withContext(Dispatchers.IO) {
			database.filmWithGenresDao().selectFilmsByGenreId(genreId)
		}

	override suspend fun saveFilmsAnGenres(films: List<FilmInfo>,
										   genres: List<GenreInfo>,
										   filmsToGenre: List<FilmToGenre>) {
		withContext(Dispatchers.IO) {
			database.filmWithGenresDao().insertFilmsAnGenres(films, genres, filmsToGenre)
		}
	}

	override suspend fun clearFilmsAnGenres() {
		withContext(Dispatchers.IO) {
			database.filmWithGenresDao().clearFilmAndGenres()
		}
	}
}
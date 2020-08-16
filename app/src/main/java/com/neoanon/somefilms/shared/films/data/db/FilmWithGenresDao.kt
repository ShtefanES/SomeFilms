package com.neoanon.somefilms.shared.films.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
abstract class FilmWithGenresDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	abstract suspend fun insertFilm(films: List<FilmInfo>)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	abstract suspend fun insertGenre(genres: List<GenreInfo>)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	abstract suspend fun insertFilmToGenre(filmToGenres: List<FilmToGenre>)

	@Transaction
	open suspend fun insertFilmsAnGenres(films: List<FilmInfo>,
										 genres: List<GenreInfo>,
										 filmsToGenre: List<FilmToGenre>) {
		insertFilm(films)
		insertGenre(genres)
		insertFilmToGenre(filmsToGenre)
	}

	@Query("SELECT * FROM genre_info")
	abstract suspend fun selectGenres(): List<GenreInfo>

	@Query("SELECT * FROM film_to_genre WHERE genre_id=:genreId")
	abstract suspend fun selectFilmToGenre(genreId: Long): List<FilmToGenre>

	@Query("SELECT * FROM film_info")
	abstract suspend fun selectFilms(): List<FilmInfo>

	@Query("SELECT * FROM film_info WHERE id=:filmId")
	abstract suspend fun selectFilmById(filmId: Long): FilmInfo

	@Transaction
	open suspend fun selectFilmsByGenreId(genreId: Long): List<FilmInfo> {
		val films = ArrayList<FilmInfo>()
		val filmToGenres = selectFilmToGenre(genreId)
		filmToGenres.forEach { filmToGenre ->
			val film = selectFilmById(filmToGenre.filmId)
			films.add(film)
		}
		return films
	}

	@Query("DELETE FROM genre_info")
	abstract suspend fun clearGenres()

	@Query("DELETE FROM film_info")
	abstract suspend fun clearFilms()

	@Query("DELETE FROM film_to_genre")
	abstract suspend fun clearFilmToGenres()

	@Transaction
	open suspend fun clearFilmAndGenres() {
		clearGenres()
		clearFilms()
		clearFilmToGenres()
	}
}
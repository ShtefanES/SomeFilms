package com.neoanon.somefilms.shared.films.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
	entities = [FilmInfo::class, GenreInfo::class, FilmToGenre::class],
	version = 1,
	exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

	abstract fun filmWithGenresDao(): FilmWithGenresDao
}
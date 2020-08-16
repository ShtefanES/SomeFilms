package com.neoanon.somefilms.shared.films.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "film_to_genre",
    primaryKeys = ["film_id", "genre_id"]
)
data class FilmToGenre(
    @ColumnInfo(name = "film_id")
    var filmId: Long,
    @ColumnInfo(name = "genre_id")
    var genreId: Long
)
package com.neoanon.somefilms.shared.films.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_info")
data class GenreInfo(
    @PrimaryKey
    var id: Long,
    var name: String
)
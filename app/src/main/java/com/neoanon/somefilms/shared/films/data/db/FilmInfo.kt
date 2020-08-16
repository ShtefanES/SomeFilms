package com.neoanon.somefilms.shared.films.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "film_info")
data class FilmInfo(
    @PrimaryKey
    var id: Long,
    @ColumnInfo(name = "localized_name")
    var localizedName: String,
    var name: String,
    var year: Int,
    var rating: Double,
    var imageUrl: String,
    var description: String
)
package com.chathil.games.data.local.entity

import androidx.room.TypeConverter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class GenreEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String? = null,
    @SerialName("games_count")
    val gamesCount: Int? = 0,
    @SerialName("image_background")
    val imageBackground: String? = null
)

class GenreEntityConverter {
    @TypeConverter
    fun encode(value: List<GenreEntity>): String {
        return Json { encodeDefaults = true }.encodeToString(value)
    }

    @TypeConverter
    fun decode(databaseValue: String): List<GenreEntity>{
        return Json.decodeFromString(databaseValue)
    }
}



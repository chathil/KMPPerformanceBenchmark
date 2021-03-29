package com.chathil.games.data.local.entity

import androidx.room.TypeConverter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Serializable
data class TagEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String? = null,
    @SerialName("language")
    val language: String? = null,
    @SerialName("games_count")
    val gamesCount: Int? = 0,
    @SerialName("image_background")
    val imageBackground: String? = null
)

class TagEntityConverter {
    @TypeConverter
    fun encode(value: List<TagEntity>): String {
        return Json { encodeDefaults = true }.encodeToString(value)
    }

    @TypeConverter
    fun decode(databaseValue: String): List<TagEntity>{
        return Json.decodeFromString(databaseValue)
    }
}
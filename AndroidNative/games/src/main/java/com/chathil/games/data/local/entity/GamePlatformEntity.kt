package com.chathil.games.data.local.entity

import androidx.room.TypeConverter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class GamePlatformEntity(
    @SerialName("platform")
    val platform: PlatformEntity? = null,
    @SerialName("released_at")
    val releasedAt: String? = null,
    @SerialName("requirements_en")
    val requirementsEn: RequirementEntity? = null
)

@Serializable
data class PlatformEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("year_end")
    val yearEnd: Int? = null,
    @SerialName("year_start")
    val yearStart: Int? = null,
    @SerialName("games_count")
    val gamesCount: Int? = 0,
    @SerialName("image_background")
    val imageBackground: String? = null
)

@Serializable
data class RequirementEntity(
    val minimum: String? = null,
    val recommended: String? = null
)

class GamePlatformEntityConverter {
    @TypeConverter
    fun encode(value: List<GamePlatformEntity>): String {
        return Json { encodeDefaults = true }.encodeToString(value)
    }

    @TypeConverter
    fun decode(databaseValue: String): List<GamePlatformEntity>{
        return Json.decodeFromString(databaseValue)
    }
}
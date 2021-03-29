package com.chathil.games.data.local.entity

import androidx.room.TypeConverter
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Serializable
data class ShortScreenshotEntity(
    val id: Int,
    val image: String? = null
)

class ShortScreenshotEntityConverter {
    @TypeConverter
    fun encode(value: List<ShortScreenshotEntity>): String {
        return Json { encodeDefaults = true }.encodeToString(value)
    }

    @TypeConverter
    fun decode(databaseValue: String): List<ShortScreenshotEntity>{
        return Json.decodeFromString(databaseValue)
    }
}



package com.chathil.games.data.local.entity

import androidx.room.TypeConverter
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class RatingEntity(
    val id: Int,
    val title: String,
    val count: Int,
    val percent: Float
)

class RatingEntityConverter {
    @TypeConverter
    fun encode(value: List<RatingEntity>): String {
        return Json { encodeDefaults = true }.encodeToString(value)
    }

    @TypeConverter
    fun decode(databaseValue: String): List<RatingEntity>{
        return Json.decodeFromString(databaseValue)
    }
}

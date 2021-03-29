package com.chathil.games.data.local.entity

import androidx.room.TypeConverter
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class ParentPlatformEntity(
    val id: Int,
    val name: String,
    val slug: String? = null
)

class ParentPlatformEntityConverter {
    @TypeConverter
    fun encode(value: List<ParentPlatformEntity>): String {
        return Json { encodeDefaults = true }.encodeToString(value)
    }

    @TypeConverter
    fun decode(databaseValue: String): List<ParentPlatformEntity> {
        return Json.decodeFromString(databaseValue)
    }
}




package co.touchlab.kampkit.data.local.entity

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val format = Json { encodeDefaults = true }

@Serializable
data class ShortScreenshotEntity(
    val id: Int,
    val image: String? = null
)

val listOfShortScreenshotAdapter = object : ColumnAdapter<List<ShortScreenshotEntity>, String> {
    override fun decode(databaseValue: String): List<ShortScreenshotEntity> =
        Json.decodeFromString(databaseValue)
    override fun encode(value: List<ShortScreenshotEntity>): String = format.encodeToString(value)
}




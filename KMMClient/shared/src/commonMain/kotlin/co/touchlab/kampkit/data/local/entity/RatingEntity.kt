package co.touchlab.kampkit.data.local.entity

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val format = Json { encodeDefaults = true }

@Serializable
data class RatingEntity(
    val id: Int,
    val title: String,
    val count: Int,
    val percent: Float
)

val listOfRatingsAdapter = object : ColumnAdapter<List<RatingEntity>, String> {
    override fun decode(databaseValue: String): List<RatingEntity> =
        Json.decodeFromString(databaseValue)
    override fun encode(value: List<RatingEntity>): String = format.encodeToString(value)
}

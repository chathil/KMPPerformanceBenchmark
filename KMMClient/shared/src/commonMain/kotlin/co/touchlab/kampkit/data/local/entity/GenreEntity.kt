package co.touchlab.kampkit.data.local.entity

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val format = Json { encodeDefaults = true }


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

val listOfGenreAdapter = object : ColumnAdapter<List<GenreEntity>, String> {
    override fun decode(databaseValue: String): List<GenreEntity> =
        Json.decodeFromString(databaseValue)
    override fun encode(value: List<GenreEntity>): String = format.encodeToString(value)
}



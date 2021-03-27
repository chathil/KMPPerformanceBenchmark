package co.touchlab.kampkit.data.local.entity

import co.touchlab.kampkit.data.remote.response.StoreResponse
import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val format = Json { encodeDefaults = true }

@Serializable
data class GameStoreEntity(
    @SerialName("store")
    val store: StoreEntity,
    @SerialName("url_en")
    val urlEn: String? = null
)

@Serializable
data class StoreEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String? = null,
    @SerialName("domain")
    val domain: String? = null,
    @SerialName("games_count")
    val gamesCount: Int? = 0,
    @SerialName("image_background")
    val imageBackground: String? = null
)

val listOfGameStoreAdapter = object : ColumnAdapter<List<GameStoreEntity>, String> {
    override fun decode(databaseValue: String): List<GameStoreEntity> =
        Json.decodeFromString(databaseValue)
    override fun encode(value: List<GameStoreEntity>): String = format.encodeToString(value)
}

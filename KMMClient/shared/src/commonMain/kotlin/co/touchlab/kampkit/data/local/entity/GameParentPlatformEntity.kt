package co.touchlab.kampkit.data.local.entity

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val format = Json { encodeDefaults = true }

@Serializable
data class ParentPlatformEntity(
    val id: Int,
    val name: String,
    val slug: String? = null
)

val listOfParentPlatformAdapter = object : ColumnAdapter<List<ParentPlatformEntity>, String> {
    override fun decode(databaseValue: String): List<ParentPlatformEntity> =
        Json.decodeFromString(databaseValue)
    override fun encode(value: List<ParentPlatformEntity>): String = format.encodeToString(value)
}




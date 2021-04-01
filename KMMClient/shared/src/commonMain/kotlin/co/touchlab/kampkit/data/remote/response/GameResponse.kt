package co.touchlab.kampkit.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("slug")
    val slug: String? = null,
    @SerialName("name")
    val name: String,
    @SerialName("released")
    val released: String?,
    @SerialName("tba")
    val tba: Boolean,
    @SerialName("background_image")
    val backgroundImage: String? = null,
    @SerialName("rating")
    val rating: Float,
    @SerialName("rating_top")
    val ratingTop: Float,
    @SerialName("ratings")
    val ratings: List<RatingResponse>? = emptyList(),
    @SerialName("ratings_count")
    val ratingsCount: Int,
    @SerialName("reviews_text_count")
    val reviewsTextCount: Int,
    @SerialName("added")
    val added: Int,
    @SerialName("metacritic")
    val metacritic: Int? = 0,
    @SerialName("playtime")
    val playtime: Int,
    @SerialName("suggestions_count")
    val suggestionsCount: Int,
    @SerialName("reviews_count")
    val reviewsCount: Int,
    @SerialName("saturated_color")
    val saturatedColor: String,
    @SerialName("dominant_color")
    val dominantColor: String,
    @SerialName("platforms")
    val platforms: List<GamePlatformResponse>? = emptyList(),
    @SerialName("parent_platforms")
    val parentPlatforms: List<GameParentPlatformResponse>? = emptyList(),
    @SerialName("genres")
    val genres: List<GenreResponse>? = emptyList(),
    @SerialName("stores")
    val stores: List<GameStoreResponse>? = emptyList(),
    @SerialName("clip")
    val clip: ClipResponse?,
    @SerialName("tags")
    val tags: List<TagResponse>? = emptyList(),
    @SerialName("short_screenshots")
    val shortScreenshots: List<ShortScreenshotResponse>? = emptyList()
)

@Serializable
data class RatingResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("count")
    val count: Int,
    @SerialName("percent")
    val percent: Float
)

@Serializable
data class PlatformResponse(
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
    val imageBackground: String? = null,
)

@Serializable
data class RequirementResponse(
    @SerialName("minimum")
    val minimum: String? = null,
    @SerialName("recommended")
    val recommended: String? = null
)

@Serializable
data class GamePlatformResponse(
    @SerialName("platform")
    val platform: PlatformResponse? = null,
    @SerialName("released_at")
    val releasedAt: String? = null,
    @SerialName("requirements_en")
    val requirementsEn: RequirementResponse? = null
)

@Serializable
data class ParentPlatformResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String? = null
)

@Serializable
data class GameParentPlatformResponse(
    @SerialName("platform")
    val platform: ParentPlatformResponse
)

@Serializable
data class GenreResponse(
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

@Serializable
data class StoreResponse(
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

@Serializable
data class GameStoreResponse(
    @SerialName("store")
    val store: StoreResponse,
    @SerialName("url_en")
    val urlEn: String? = null
)

@Serializable
data class ClipResponse(
    @SerialName("clip")
    val clip: String? = null
)

@Serializable
data class TagResponse(
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

@Serializable
data class ShortScreenshotResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String? = null
)

package co.touchlab.kampkit.domain.model

data class GameModel(
    val id: Int,
    val slug: String? = null,
    val name: String,
    val released: String?,
    val tba: Boolean,
    val backgroundImage: String? = null,
    val rating: Float,
    val ratingTop: Float,
    val ratings: List<RatingModel>? = emptyList(),
    val ratingsCount: Int,
    val reviewsTextCount: Int,
    val added: Int,
    val metacritic: Int? = 0,
    val playtime: Int,
    val suggestionsCount: Int,
    val reviewsCount: Int,
    val saturatedColor: String?,
    val dominantColor: String?,
    val platforms: List<GamePlatformModel>? = emptyList(),
    val parentPlatforms: List<ParentPlatformModel>? = emptyList(),
    val genres: List<GenreModel>? = emptyList(),
    val stores: List<GameStoreModel>? = emptyList(),
    val clip: String?,
    val tags: List<TagModel>? = emptyList(),
    val shortScreenshots: List<ShortScreenshotModel>? = emptyList()
)


data class RatingModel(
    val id: Int,
    val title: String,
    val count: Int,
    val percent: Float
)


data class PlatformModel(
    val id: Int,
    val name: String,
    val slug: String? = null,
    val image: String? = null,
    val yearEnd: Int? = null,
    val yearStart: Int? = null,
    val gamesCount: Int? = 0,
    val imageBackground: String? = null,
)


data class RequirementModel(
    val minimum: String? = null,
    val recommended: String? = null
)


data class GamePlatformModel(
    val platform: PlatformModel? = null,
    val releasedAt: String? = null,
    val requirementsEn: RequirementModel? = null
)


data class ParentPlatformModel(
    val id: Int,
    val name: String,
    val slug: String? = null
)


data class GenreModel(
    val id: Int,
    val name: String,
    val slug: String? = null,
    val gamesCount: Int? = 0,
    val imageBackground: String? = null
)


data class StoreModel(
    val id: Int,
    val name: String,
    val slug: String? = null,
    val domain: String? = null,
    val gamesCount: Int? = 0,
    val imageBackground: String? = null
)


data class GameStoreModel(
    val store: StoreModel,
    val urlEn: String? = null
)


data class TagModel(
    val id: Int,
    val name: String,
    val slug: String? = null,
    val language: String? = null,
    val gamesCount: Int? = 0,
    val imageBackground: String? = null
)


data class ShortScreenshotModel(
    val id: Int,
    val image: String? = null
)
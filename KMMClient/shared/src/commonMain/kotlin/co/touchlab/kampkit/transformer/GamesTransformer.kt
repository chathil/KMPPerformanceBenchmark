package co.touchlab.kampkit.transformer

import co.touchlab.kampkit.data.local.GameEntity
import co.touchlab.kampkit.data.remote.response.GameResponse
import co.touchlab.kampkit.domain.model.GameModel
import co.touchlab.kampkit.utils.TimeMeasurementUtils
import kotlinx.datetime.Clock

fun GameEntity.toDomainModel() = GameModel(
    apiId,
    slug,
    name,
    released,
    tba,
    backgroundImage,
    rating,
    ratingTop,
    ratings?.toDomainModels(),
    ratingsCount,
    reviewTextCount,
    added,
    metacritic,
    playtime,
    suggestionCount,
    reviewsCount,
    saturatedColor,
    dominantColor,
    platforms?.toDomainModels(),
    parentPlatforms?.toDomainModels(),
    genres?.toDomainModels(),
    stores?.toDomainModels(),
    clip,
    tags?.toDomainModels(),
    shortScreenshots?.toDomainModels()
)

fun List<GameEntity>.toDomainModels() =
    map { it.toDomainModel() }

fun GameResponse.toEntity() = GameEntity(
    id,
    name,
    slug,
    released,
    tba,
    backgroundImage,
    rating,
    ratingTop,
    ratings?.toEntities(),
    ratingsCount,
    reviewsTextCount,
    added,
    metacritic ?: 0,
    playtime,
    suggestionsCount,
    reviewsCount,
    saturatedColor,
    dominantColor,
    platforms?.toEntities(),
    parentPlatforms?.map { it.platform.toEntity() },
    genres?.toEntities(),
    stores?.toEntities(),
    clip?.clip,
    tags?.toEntities(),
    shortScreenshots?.toEntities()
)

fun List<GameResponse>.toEntities() = map { it.toEntity() }

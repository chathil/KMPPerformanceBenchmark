package co.touchlab.kampkit.transformer

import co.touchlab.kampkit.data.local.entity.GenreEntity
import co.touchlab.kampkit.data.remote.response.GenreResponse
import co.touchlab.kampkit.domain.model.GenreModel

fun GenreResponse.toEntity() = GenreEntity(id, name, slug, gamesCount, imageBackground)
fun List<GenreResponse>.toEntities() = map { it.toEntity() }

fun GenreEntity.toDomainModel() = GenreModel(id, name, slug, gamesCount, imageBackground)
fun List<GenreEntity>.toDomainModels() = map { it.toDomainModel() }
package co.touchlab.kampkit.transformer

import co.touchlab.kampkit.data.local.entity.TagEntity
import co.touchlab.kampkit.data.remote.response.TagResponse
import co.touchlab.kampkit.domain.model.TagModel

fun TagResponse.toEntity() = TagEntity(id, name, slug, language, gamesCount, imageBackground)
fun List<TagResponse>.toEntities() = this.map { it.toEntity() }

fun TagEntity.toDomainModel() = TagModel(id, name, slug, language, gamesCount, imageBackground)
fun List<TagEntity>.toDomainModels() = map { it.toDomainModel() }
package com.chathil.games.transformer

import com.chathil.games.data.local.entity.TagEntity
import com.chathil.games.data.remote.response.TagResponse
import com.chathil.games.domain.model.TagModel

fun TagResponse.toEntity() = TagEntity(id, name, slug, language, gamesCount, imageBackground)
fun List<TagResponse>.toEntities() = this.map { it.toEntity() }

fun TagEntity.toDomainModel() = TagModel(id, name, slug, language, gamesCount, imageBackground)
fun List<TagEntity>.toDomainModels() = map { it.toDomainModel() }
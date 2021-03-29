package com.chathil.games.transformer

import com.chathil.games.data.local.entity.GenreEntity
import com.chathil.games.data.remote.response.GenreResponse
import com.chathil.games.domain.model.GenreModel

fun GenreResponse.toEntity() = GenreEntity(id, name, slug, gamesCount, imageBackground)
fun List<GenreResponse>.toEntities() = map { it.toEntity() }

fun GenreEntity.toDomainModel() = GenreModel(id, name, slug, gamesCount, imageBackground)
fun List<GenreEntity>.toDomainModels() = map { it.toDomainModel() }
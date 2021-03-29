package com.chathil.games.transformer

import com.chathil.games.data.local.entity.ParentPlatformEntity
import com.chathil.games.data.remote.response.ParentPlatformResponse
import com.chathil.games.domain.model.ParentPlatformModel

fun ParentPlatformResponse.toEntity() = ParentPlatformEntity(id, name, slug)
fun List<ParentPlatformResponse>.toEntities() = map { it.toEntity() }

fun ParentPlatformEntity.toDomainModel() = ParentPlatformModel(id, name, slug)
fun List<ParentPlatformEntity>.toDomainModels() = map { it.toDomainModel() }
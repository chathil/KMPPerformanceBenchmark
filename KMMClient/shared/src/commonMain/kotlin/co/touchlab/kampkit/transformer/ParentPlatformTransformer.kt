package co.touchlab.kampkit.transformer

import co.touchlab.kampkit.data.local.entity.ParentPlatformEntity
import co.touchlab.kampkit.data.remote.response.GameParentPlatformResponse
import co.touchlab.kampkit.data.remote.response.ParentPlatformResponse
import co.touchlab.kampkit.domain.model.ParentPlatformModel

fun ParentPlatformResponse.toEntity() = ParentPlatformEntity(id, name, slug)
fun List<ParentPlatformResponse>.toEntities() = map { it.toEntity() }

fun ParentPlatformEntity.toDomainModel() = ParentPlatformModel(id, name, slug)
fun List<ParentPlatformEntity>.toDomainModels() = map { it.toDomainModel() }
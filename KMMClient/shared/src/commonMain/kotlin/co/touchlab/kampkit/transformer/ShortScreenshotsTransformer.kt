package co.touchlab.kampkit.transformer

import co.touchlab.kampkit.data.local.entity.ShortScreenshotEntity
import co.touchlab.kampkit.data.remote.response.ShortScreenshotResponse
import co.touchlab.kampkit.domain.model.ShortScreenshotModel

fun ShortScreenshotResponse.toEntity() = ShortScreenshotEntity(id, image)
fun List<ShortScreenshotResponse>.toEntities() = this.map { it.toEntity() }

fun ShortScreenshotEntity.toDomainModel() = ShortScreenshotModel(id, image)
fun List<ShortScreenshotEntity>.toDomainModels() = map { it.toDomainModel() }
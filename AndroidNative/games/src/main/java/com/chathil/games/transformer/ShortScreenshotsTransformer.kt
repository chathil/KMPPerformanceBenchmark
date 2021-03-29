package com.chathil.games.transformer

import com.chathil.games.data.local.entity.ShortScreenshotEntity
import com.chathil.games.data.remote.response.ShortScreenshotResponse
import com.chathil.games.domain.model.ShortScreenshotModel

fun ShortScreenshotResponse.toEntity() = ShortScreenshotEntity(id, image)
fun List<ShortScreenshotResponse>.toEntities() = this.map { it.toEntity() }

fun ShortScreenshotEntity.toDomainModel() = ShortScreenshotModel(id, image)
fun List<ShortScreenshotEntity>.toDomainModels() = map { it.toDomainModel() }
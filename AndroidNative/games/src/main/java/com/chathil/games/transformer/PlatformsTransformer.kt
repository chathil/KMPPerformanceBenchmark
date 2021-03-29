package com.chathil.games.transformer

import com.chathil.games.data.local.entity.GamePlatformEntity
import com.chathil.games.data.local.entity.PlatformEntity
import com.chathil.games.data.local.entity.RequirementEntity
import com.chathil.games.data.remote.response.GamePlatformResponse
import com.chathil.games.data.remote.response.PlatformResponse
import com.chathil.games.data.remote.response.RequirementResponse
import com.chathil.games.domain.model.GamePlatformModel
import com.chathil.games.domain.model.PlatformModel
import com.chathil.games.domain.model.RequirementModel

fun GamePlatformResponse.toEntity() = GamePlatformEntity(platform?.toEntity(), releasedAt, requirementsEn?.toEntity())
fun PlatformResponse.toEntity() = PlatformEntity(id, name, slug, image, yearEnd, yearStart, gamesCount, imageBackground)
fun RequirementResponse.toEntity() = RequirementEntity(minimum, recommended)
fun List<GamePlatformResponse>.toEntities() = map { it.toEntity() }

fun GamePlatformEntity.toDomainModel() = GamePlatformModel(
    platform?.toDomainModel(), releasedAt,
    requirementsEn?.toDomainModel()
)
fun PlatformEntity.toDomainModel() = PlatformModel(id, name, slug, image, yearEnd, yearStart, gamesCount, imageBackground)
fun RequirementEntity.toDomainModel() = RequirementModel(minimum, recommended)
fun List<GamePlatformEntity>.toDomainModels() = map { it.toDomainModel() }

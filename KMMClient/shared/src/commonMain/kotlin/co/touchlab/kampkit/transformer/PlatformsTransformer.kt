package co.touchlab.kampkit.transformer

import co.touchlab.kampkit.data.local.entity.GamePlatformEntity
import co.touchlab.kampkit.data.local.entity.PlatformEntity
import co.touchlab.kampkit.data.local.entity.RequirementEntity
import co.touchlab.kampkit.data.remote.response.GamePlatformResponse
import co.touchlab.kampkit.data.remote.response.PlatformResponse
import co.touchlab.kampkit.data.remote.response.RequirementResponse
import co.touchlab.kampkit.domain.model.GamePlatformModel
import co.touchlab.kampkit.domain.model.PlatformModel
import co.touchlab.kampkit.domain.model.RequirementModel

fun GamePlatformResponse.toEntity() = GamePlatformEntity(platform?.toEntity(), releasedAt, requirementsEn?.toEntity())
fun PlatformResponse.toEntity() = PlatformEntity(id, name, slug, image, yearEnd, yearStart, gamesCount, imageBackground)
fun RequirementResponse.toEntity() = RequirementEntity(minimum, recommended)
fun List<GamePlatformResponse>.toEntities() = map { it.toEntity() }

fun GamePlatformEntity.toDomainModel() = GamePlatformModel(platform?.toDomainModel(), releasedAt, requirementsEn?.toDomainModel())
fun PlatformEntity.toDomainModel() = PlatformModel(id, name, slug, image, yearEnd, yearStart, gamesCount, imageBackground)
fun RequirementEntity.toDomainModel() = RequirementModel(minimum, recommended)
fun List<GamePlatformEntity>.toDomainModels() = map { it.toDomainModel() }

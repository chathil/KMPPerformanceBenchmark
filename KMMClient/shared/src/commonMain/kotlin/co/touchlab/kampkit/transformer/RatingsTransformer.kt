package co.touchlab.kampkit.transformer

import co.touchlab.kampkit.data.local.entity.RatingEntity
import co.touchlab.kampkit.data.remote.response.RatingResponse
import co.touchlab.kampkit.domain.model.RatingModel


fun RatingResponse.toEntity()  = RatingEntity(id, title, count, percent)
fun List<RatingResponse>.toEntities() = this.map { it.toEntity() }

fun RatingEntity.toDomainModel() = RatingModel(id, title, count, percent)
fun List<RatingEntity>.toDomainModels() = map { it.toDomainModel() }
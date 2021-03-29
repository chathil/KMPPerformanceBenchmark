package com.chathil.games.transformer

import com.chathil.games.data.local.entity.RatingEntity
import com.chathil.games.data.remote.response.RatingResponse
import com.chathil.games.domain.model.RatingModel


fun RatingResponse.toEntity()  = RatingEntity(id, title, count, percent)
fun List<RatingResponse>.toEntities() = this.map { it.toEntity() }

fun RatingEntity.toDomainModel() = RatingModel(id, title, count, percent)
fun List<RatingEntity>.toDomainModels() = map { it.toDomainModel() }
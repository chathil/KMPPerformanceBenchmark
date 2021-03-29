package com.chathil.games.transformer

import com.chathil.games.data.local.entity.GameStoreEntity
import com.chathil.games.data.local.entity.StoreEntity
import com.chathil.games.data.remote.response.GameStoreResponse
import com.chathil.games.data.remote.response.StoreResponse
import com.chathil.games.domain.model.GameStoreModel
import com.chathil.games.domain.model.StoreModel

fun StoreResponse.toEntity() = StoreEntity(id, name, slug, domain, gamesCount, imageBackground)
fun GameStoreResponse.toEntity() = GameStoreEntity(store.toEntity(), urlEn)
fun List<GameStoreResponse>.toEntities() = this.map { it.toEntity() }

fun StoreEntity.toDomainModel() = StoreModel(id, name, slug, domain, gamesCount, imageBackground)
fun GameStoreEntity.toDomainModel() = GameStoreModel(store.toDomainModel(), urlEn)
fun List<GameStoreEntity>.toDomainModels() = map { it.toDomainModel() }
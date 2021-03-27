package co.touchlab.kampkit.transformer

import co.touchlab.kampkit.data.local.entity.GameStoreEntity
import co.touchlab.kampkit.data.local.entity.StoreEntity
import co.touchlab.kampkit.data.remote.response.GameStoreResponse
import co.touchlab.kampkit.data.remote.response.StoreResponse
import co.touchlab.kampkit.domain.model.GameStoreModel
import co.touchlab.kampkit.domain.model.StoreModel

fun StoreResponse.toEntity() = StoreEntity(id, name, slug, domain, gamesCount, imageBackground)
fun GameStoreResponse.toEntity() = GameStoreEntity(store.toEntity(), urlEn)
fun List<GameStoreResponse>.toEntities() = this.map { it.toEntity() }

fun StoreEntity.toDomainModel() = StoreModel(id, name, slug, domain, gamesCount, imageBackground)
fun GameStoreEntity.toDomainModel() = GameStoreModel(store.toDomainModel(), urlEn)
fun List<GameStoreEntity>.toDomainModels() = map { it.toDomainModel() }
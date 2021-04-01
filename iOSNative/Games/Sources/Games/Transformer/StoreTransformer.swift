//
//  File.swift
//  
//
//  Created by Abdul Chathil on 31/03/21.
//

import Foundation

extension GameStoreResponse {
  func toEntity() -> GameStoreEntity {
    GameStoreEntity(store: store.toEntity(), urlEn: urlEn)
  }
}

extension Array where Element == GameStoreResponse {
  func toEntities() -> [GameStoreEntity] {
    map { $0.toEntity() }
  }
}

extension StoreResponse {
  func toEntity() -> StoreEntity {
    StoreEntity(id: id, name: name, slug: slug, domain: domain, gamesCount: gamesCount, imageBackground: imageBackground)
  }
}

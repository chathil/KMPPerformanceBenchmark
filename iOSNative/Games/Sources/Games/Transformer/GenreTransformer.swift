//
//  File.swift
//  
//
//  Created by Abdul Chathil on 31/03/21.
//

import Foundation

extension GenreResponse {
  func toEntity() -> GenreEntity {
    GenreEntity(id: id, name: name, slug: slug, gamesCount: gamesCount, imageBackground: imageBackground)
  }
}

extension Array where Element == GenreResponse {
  func toEntities() -> [GenreEntity] {
    map {$0.toEntity()}
  }
}

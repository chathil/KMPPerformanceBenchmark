//
//  File.swift
//  
//
//  Created by Abdul Chathil on 31/03/21.
//

import Foundation

extension TagResponse {
  func toEntity() -> TagEntity {
    TagEntity(id: id, name: name, slug: slug, language: language, gamesCount: gamesCount, imageBackground: imageBackground)
  }
}

extension Array where Element == TagResponse {
  func toEntities() -> [TagEntity] {
    map { $0.toEntity() }
  }
}

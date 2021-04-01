//
//  File.swift
//  
//
//  Created by Abdul Chathil on 31/03/21.
//

import Foundation

extension RatingResponse {
  func toEntity() -> RatingEntity {
    RatingEntity(id: id, title: title, count: count, percent: percent)
  }
}

extension Array where Element == RatingResponse {
  func toEntitities() -> [RatingEntity] {
    map { $0.toEntity() }
  }
}

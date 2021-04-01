//
//  File.swift
//  
//
//  Created by Abdul Chathil on 31/03/21.
//

import Foundation

extension ShortScreenshotResponse {
  func toEntity() -> ShortScreenshotEntity {
    ShortScreenshotEntity(id: id, image: image)
  }
}

extension Array where Element == ShortScreenshotResponse {
  func toEntities() -> [ShortScreenshotEntity] {
    map { $0.toEntity() }
  }
}

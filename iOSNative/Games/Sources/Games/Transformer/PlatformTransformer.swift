//
//  File.swift
//  
//
//  Created by Abdul Chathil on 31/03/21.
//

import Foundation

extension GamePlatformResponse {
  func toEntity() -> GamePlatformEntity {
    GamePlatformEntity(platform: platform?.toEntity(), releasedAt: releasedAt, requiremensEn: requirementsEn?.toEntity())
  }
}

extension Array where Element == GamePlatformResponse {
  func toEntities() -> [GamePlatformEntity] {
    map { $0.toEntity() }
  }
}

extension PlatformResponse {
  func toEntity() -> PlatformEntity {
    PlatformEntity(id: id, name: name, slug: slug, image: image, yearEnd: yearEnd, yearStart: yearStart, gamesCount: gamesCount, imageBackground: imageBackground)
  }
}

extension RequirementResponse {
  func toEntity() -> RequirementEntity {
    RequirementEntity(minimum: minimum, recommended: recommended)
  }
}

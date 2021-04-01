//
//  File.swift
//  
//
//  Created by Abdul Chathil on 30/03/21.
//

import Foundation

struct GamePlatformEntity {
  let platform: PlatformEntity?
  let releasedAt: String?
  let requiremensEn: RequirementEntity?
}

struct PlatformEntity {
  let id: Int
  let name: String
  let slug: String?
  let image: String?
  let yearEnd: Int?
  let yearStart: Int?
  let gamesCount: Int?
  let imageBackground: String
}

struct RequirementEntity {
  let minimum: String?
  let recommended: String
}

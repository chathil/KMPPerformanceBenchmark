//
//  File.swift
//  
//
//  Created by Abdul Chathil on 31/03/21.
//

import Foundation

extension Array where Element == GameParentPlatformResponse {
  func toEntities() -> [ParentPlatformEntity] {
    map { $0.platform.toEntity() }
  }
}

extension ParentPlatformResponse {
  func toEntity() -> ParentPlatformEntity {
    ParentPlatformEntity(id: id, name: name, slug: slug)
  }
}

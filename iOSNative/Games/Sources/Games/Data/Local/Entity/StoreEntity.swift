//
//  File.swift
//  
//
//  Created by Abdul Chathil on 30/03/21.
//

import Foundation

struct GameStoreEntity {
  public let store: StoreEntity
  public let urlEn: String?
}

public struct StoreEntity {
  public let id: Int
  public let name: String
  public let slug: String?
  public let domain: String?
  public let gamesCount: Int
  public let imageBackground: String?
}

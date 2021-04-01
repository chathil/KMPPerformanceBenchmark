//
//  File.swift
//  
//
//  Created by Abdul Chathil on 31/03/21.
//

import Foundation
import CoreData

extension GameResponse {
  func toEntity(context: NSManagedObjectContext) -> GameEntity {
    let entity = GameEntity(context: context)
    entity.id = id
    entity.slug = slug
    entity.name = name
    entity.released = released
    entity.tba = tba
    entity.backgroundImage = backgroundImage
    entity.rating = rating ?? 0.0
    entity.ratingTop = ratingTop ?? 0.0
    entity.ratingsArr = ratings.toEntitities()
    entity.ratingsCount = Int16(ratingsCount)
    entity.reviewTextCount = Int16(reviewsTextCount)
    entity.added = Int16(added)
    entity.metacritic = Int16(metacritic ?? 0)
    entity.playtime = Int16(playtime)
    entity.suggestionCount = Int16(suggestionsCount)
    entity.reviewsCount = Int16(reviewsCount)
    entity.saturatedColor = saturatedColor
    entity.dominantColor = dominantColor
    entity.platformsArr = platforms.toEntities()
    entity.parentPlatformsArr = parentPlatforms.toEntities()
    entity.genresArr = genres.toEntities()
    entity.storesArr = stores.toEntities()
    entity.clip = clip?.clip
    entity.tagsArr = tags.toEntities()
    entity.shortScreenshotsArr = shortScreenshots.toEntities()
    return entity
  }
}

extension Array where Element == GameResponse {
  func toEntities(context: NSManagedObjectContext) -> [GameEntity] {
    map { $0.toEntity(context: context) }
  }
}

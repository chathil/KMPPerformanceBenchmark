//
//  File.swift
//  
//
//  Created by Abdul Chathil on 30/03/21.
//

import Foundation

extension GameEntity {

  var genresArr: [GenreEntity] {
    get {
        return genres as? Array<GenreEntity> ?? []
    }
    set {
        genres = newValue as NSArray
    }
  }
  
  var parentPlatformsArr: [ParentPlatformEntity] {
    get {
      return parentPlatforms as? Array<ParentPlatformEntity> ?? []
    }
    set {
      return parentPlatforms = newValue as NSArray
    }
  }
  
  var platformsArr: [GamePlatformEntity] {
    get {
      return platforms as? Array<GamePlatformEntity> ?? []
    }
    set {
      return platforms = newValue as NSArray
    }
  }
  
  var ratingsArr: [RatingEntity] {
    get {
      return ratings as? Array<RatingEntity> ?? []
    }
    set {
      return ratings = newValue as NSArray
    }
  }
  
  var shortScreenshotsArr: [ShortScreenshotEntity] {
    get {
      return shortScreenshots as? Array<ShortScreenshotEntity> ?? []
    }
    set {
      return shortScreenshots  = newValue as NSArray
    }
  }
  
  var storesArr: [GameStoreEntity] {
    get {
      return stores as? Array<GameStoreEntity> ?? []
    }
    set {
      return stores = newValue as NSArray
    }
  }
  
  var tagsArr: [TagEntity] {
    get {
      return tags as? Array<TagEntity> ?? []
    }
    set {
      return tags = newValue as NSArray
    }
  }
  
}

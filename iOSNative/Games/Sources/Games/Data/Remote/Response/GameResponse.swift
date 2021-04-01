//
//  File.swift
//  
//
//  Created by Abdul Chathil on 30/03/21.
//

import Foundation

public struct GameResponse: Codable, Identifiable {
  public let id: Int32
  public let slug: String?
  public let name: String
  public let released: String?
  public let tba: Bool
  public let backgroundImage: String?
  public let rating: Double?
  public let ratingTop: Double?
  public let ratings: [RatingResponse]
  public let ratingsCount: Int
  public let reviewsTextCount: Int
  public let added: Int
  public let metacritic: Int16?
  public let playtime: Int
  public let suggestionsCount: Int
  public let reviewsCount: Int
  public let saturatedColor: String
  public let dominantColor: String
  public let platforms: [GamePlatformResponse]
  public let parentPlatforms: [GameParentPlatformResponse]
  public let genres: [GenreResponse]
  public let stores: [GameStoreResponse]
  public let clip: ClipResponse?
  public let tags: [TagResponse]
  public let shortScreenshots: [ShortScreenshotResponse]
  
  private enum CodingKeys: String, CodingKey {
    case id = "id"
    case name = "name"
    case slug = "slug"
    case released = "released"
    case tba = "tba"
    case backgroundImage = "background_image"
    case rating = "rating"
    case ratingTop = "rating_top"
    case ratings = "ratings"
    case ratingsCount = "ratings_count"
    case reviewsTextCount = "reviews_text_count"
    case added = "added"
    case metacritic = "metacritic"
    case playtime = "playtime"
    case suggestionsCount = "suggestions_count"
    case reviewsCount = "reviews_count"
    case saturatedColor = "saturated_color"
    case dominantColor = "dominant_color"
    case platforms = "platforms"
    case parentPlatforms = "parent_platforms"
    case genres = "genres"
    case stores = "stores"
    case clip = "clip"
    case tags = "tags"
    case shortScreenshots = "short_screenshots"
  }
  
}

public struct RatingResponse: Codable {
  public let id: Int
  public let title: String
  public let count: Int
  public let percent: Float
}

public struct GenreResponse: Codable {
  public let id: Int
  public let name: String
  public let slug: String?
  public let gamesCount: Int?
  public let imageBackground: String?
  private enum CodingKeys: String, CodingKey {
    case id = "id"
    case name = "name"
    case slug = "slug"
    case gamesCount = "games_count"
    case imageBackground = "image_background"
  }
}

public struct PlatformResponse: Codable {
  public let id: Int
  public let name: String
  public let slug: String?
  public let image: String?
  public let yearEnd: Int?
  public let yearStart: Int?
  public let gamesCount: Int?
  public let imageBackground: String
  private enum CodingKeys: String, CodingKey {
    case id = "id"
    case name = "name"
    case slug = "slug"
    case image = "image"
    case yearEnd = "year_end"
    case yearStart = "year_start"
    case gamesCount = "games_count"
    case imageBackground = "image_background"
  }
}

public struct RequirementResponse: Codable {
  public let minimum: String?
  public let recommended: String
}

public struct GamePlatformResponse: Codable {
  public let platform: PlatformResponse?
  public let releasedAt: String?
  public let requirementsEn: RequirementResponse?
  private enum CodingKeys: String, CodingKey {
    case platform = "platform"
    case releasedAt = "released_at"
    case requirementsEn = "requirements_en"
  }
}

public struct ParentPlatformResponse: Codable {
  public let id: Int
  public let name: String
  public let slug: String?
}

public struct GameParentPlatformResponse: Codable {
  public let platform: ParentPlatformResponse
}

public struct StoreResponse: Codable {
  public let id: Int
  public let name: String
  public let slug: String?
  public let domain: String?
  public let gamesCount: Int
  public let imageBackground: String?
  private enum CodingKeys: String, CodingKey {
    case id = "id"
    case name = "name"
    case slug = "slug"
    case domain = "domain"
    case gamesCount = "games_count"
    case imageBackground = "image_background"
  }
}

public struct GameStoreResponse: Codable {
  public let store: StoreResponse
  public let urlEn: String?
  private enum CodingKeys: String, CodingKey {
    case store = "id"
    case urlEn = "name"
  }
}

public struct ClipResponse: Codable {
  public let clip: String?
}

public struct TagResponse: Codable {
  public let id: Int
  public let name: String
  public let slug: String?
  public let language: String?
  public let gamesCount: Int?
  public let imageBackground: String?
  private enum CodingKeys: String, CodingKey {
    case id = "id"
    case name = "name"
    case slug = "slug"
    case language = "language"
    case gamesCount = "games_count"
    case imageBackground = "image_background"
  }
}

public struct ShortScreenshotResponse:Codable {
  public let id: Int
  public let image: String?
}

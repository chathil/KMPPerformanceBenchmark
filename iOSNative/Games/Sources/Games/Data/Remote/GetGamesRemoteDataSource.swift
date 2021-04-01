//
//  File.swift
//  
//
//  Created by Abdul Chathil on 30/03/21.
//

import Foundation
import Combine
import Alamofire

struct API {
  static let baseUrl = "http://127.0.0.1:8080/"
}

public struct GetGamesRemoteDataSource {
  public init() {}
  public func execute() -> AnyPublisher<[GameResponse],Error> {
    Future<[GameResponse], Error> { completion in
      if let url = URL(string: API.baseUrl + "games") {
        AF.request(url).validate().responseDecodable(of: [GameResponse].self) { response in
          switch response.result {
          case .success(let value): completion(.success(value))
          case .failure: completion(.failure(URLError.invalidResponse))
          }
        }
        
      }
    }.eraseToAnyPublisher()
  }
}

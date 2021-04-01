//
//  File.swift
//  
//
//  Created by Abdul Chathil on 30/03/21.
//

import Foundation
import  Combine

public protocol GetGamesUseCase {
  func execute() -> AnyPublisher<[GameEntity], Error>
}

public class GetGamesInteractor: GetGamesUseCase {
  private let _repository: GetGamesRepository
  public init(repository: GetGamesRepository) {
    _repository = repository
  }
  
  public func execute() -> AnyPublisher<[GameEntity], Error> {
    _repository.execute()
  }
}

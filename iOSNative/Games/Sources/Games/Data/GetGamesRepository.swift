//
//  File.swift
//  
//
//  Created by Abdul Chathil on 30/03/21.
//

import Foundation
import Combine

public class GetGamesRepository {
  private let _localDataSource: GetGamesLocalDataSource
  private let _remoteDataSource: GetGamesRemoteDataSource
  
  public init(
    localDataSource: GetGamesLocalDataSource,
    remoteDataSource: GetGamesRemoteDataSource) {
    _localDataSource = localDataSource
    _remoteDataSource = remoteDataSource
  }
  
  public func execute() -> AnyPublisher<[GameEntity], Error> {
    //    _localDataSource.allGames()
    //      .flatMap { result -> AnyPublisher<[GameEntity], Error> in
    //
    //      }.eraseToAnyPublisher()
    
    let b = _remoteDataSource.execute().map { $0.toEntities(context: self._localDataSource._context) }
    _localDataSource.insertGames()
    return b.eraseToAnyPublisher()
  }
}

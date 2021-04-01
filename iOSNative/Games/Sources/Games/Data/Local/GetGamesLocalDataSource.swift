//
//  File.swift
//  
//
//  Created by Abdul Chathil on 30/03/21.
//

import Foundation
import CoreData
import Combine

public class GetGamesLocalDataSource {
  public let _context: NSManagedObjectContext
  
  public init (context: NSManagedObjectContext) {
    self._context = context
  }
  
  public func insertGames() {
    do {
      try self._context.save()
    } catch let error as NSError {
      print("error")
      print(error.localizedDescription)
    }
  }
  
  public func allGames() -> AnyPublisher<[GameEntity], Error> {
    Future<[GameEntity], Error> { completion in
      let fetchRequest = NSFetchRequest<NSFetchRequestResult>(entityName: "GameEntity")
      do {
        let result = try! self._context.fetch(fetchRequest) as? [GameEntity]
        completion(.success(result ?? []))
      }
    }.eraseToAnyPublisher()
  }
}

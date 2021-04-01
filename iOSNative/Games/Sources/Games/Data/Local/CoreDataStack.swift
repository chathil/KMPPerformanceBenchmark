//
//  File.swift
//  
//
//  Created by Abdul Chathil on 31/03/21.
//

import CoreData

public struct CoreDataStack {
  private let containerName: String
    public static var viewContext: NSManagedObjectContext {
        return persistentContainer.viewContext
    }
    
    public static var persistentContainer: NSPersistentContainer = {
        let container = NSPersistentContainer(name: "GameEntity")
        container.loadPersistentStores(completionHandler: { (storeDescription, error) in
            if let error = error as NSError? {
                fatalError("Unresolved error \(error), \(error.userInfo)")
            }
        })
        return container
    }()
  
  init(containerName: String) {
      self.containerName = containerName
      _ = persistentContainer
  }
  
}

extension NSManagedObjectContext {
    func saveContext() throws {
        guard hasChanges else { return }
        try save()
    }
}

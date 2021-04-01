//
//  IOSNativeApp.swift
//  IOSNative
//
//  Created by Abdul Chathil on 29/03/21.
//

import SwiftUI
import Games

@main
struct IOSNativeApp: App {
  let mm: GetGamesPresenter = {
    let repo = GetGamesRepository(localDataSource: GetGamesLocalDataSource(context: CoreDataStack.viewContext), remoteDataSource: GetGamesRemoteDataSource())
    let useCase = GetGamesInteractor(repository: repo)
    let presenter = GetGamesPresenter(useCase: useCase)
    return presenter
  }

    var body: some Scene {
        WindowGroup {
          ContentView(presenter: mm)
//            .environment(\.managedObjectContext, CoreDataStack.viewContext)
        }
    }
}

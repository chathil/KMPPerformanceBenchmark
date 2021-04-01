//
//  ContentView.swift
//  IOSNative
//
//  Created by Abdul Chathil on 29/03/21.
//

import SwiftUI
import Games

struct ContentView: View {
  @Environment(\.managedObjectContext) var managedObjectContext
  @ObservedObject var presenter: GetGamesPresenter
  var body: some View {
    Text("Hello, world!")
      .padding().onAppear {
        presenter.execute()
      }
  }
}

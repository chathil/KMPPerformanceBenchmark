//
//  File.swift
//  
//
//  Created by Abdul Chathil on 30/03/21.
//

import Foundation
import Combine

public class GetGamesPresenter: ObservableObject {
  private var cancellables: Set<AnyCancellable> = []
  private let _useCase: GetGamesUseCase
  
  @Published var games: [GameEntity] = []
  
  public init(useCase: GetGamesUseCase) {
    _useCase = useCase
  }
  
  public func execute() {
    _useCase.execute().receive(on: RunLoop.main)
      .sink(receiveCompletion: {_ in
        
      }, receiveValue: {
        self.games = $0
        print("results: \($0)")
      }).store(in: &cancellables)
  }
  
}

//
//  ViewController.swift
//  KaMPKitiOS
//
//  Created by Kevin Schildhorn on 12/18/19.
//  Copyright © 2019 Touchlab. All rights reserved.
//

import UIKit
import shared

class BreedsViewController: UIViewController {
  
  let log = koin.get(objCClass: Kermit.self, parameter: "ViewController") as! Kermit
  let presenter = koin.get(objCClass: GamesPresenter.self, parameter: "") as! GamesPresenter
  
  var parsingTimeStart: Int64 = 0
  var parsingTime = 0
  
  var responseToEntityMappingTimeStart: Int64 = 0
  var responseToEntityMappingTime = 0
  
  var entityWritingTimeStart: Int64 = 0
  var entityWritingTime = 0
  
  var entityReadingTimeStart: Int64 = 0
  var entityReadingTime = 0
  
  var entityToDomainModelMappingTimeStart: Int64 = 0
  var entityToDomainModelMappingTime = 0
  
  @objc
  func getBreedsForced() {
    
  }
  
  override func viewDidLoad() {
    super.viewDidLoad()
    
    let timeMeasurementUtils = TimeMeasurementUtils(
      parsingTimeStart: { self.parsingTimeStart = $0.int64Value },
      parsingTimeEnd: { self.parsingTime = Int($0.int64Value - self.parsingTimeStart) },
      responseToEntityMappingTimeStart: { self.responseToEntityMappingTimeStart = $0.int64Value },
      responseToEntityMappingTimeEnd: { self.responseToEntityMappingTime = Int($0.int64Value - self.responseToEntityMappingTimeStart) },
      entityWritingTimeStart: { self.entityWritingTimeStart = $0.int64Value },
      entityWritingTimeEnd: { self.entityWritingTime = Int($0.int64Value - self.entityWritingTimeStart) },
      entityReadingTimeStart: { self.entityReadingTimeStart = $0.int64Value },
      entityReadingTimeEnd: { self.entityReadingTime = Int($0.int64Value - self.entityReadingTimeStart) },
      entityToDomainModelMappingTimeStart: { self.entityToDomainModelMappingTimeStart = $0.int64Value },
      entityToDomainModelMappingTimeEnd: {
        self.entityToDomainModelMappingTime = Int($0.int64Value - self.entityToDomainModelMappingTimeStart)
        self.getTimes()
      })
    
    presenter.getList(force: true, timeMeasurementUtils: timeMeasurementUtils, onLoading: {_ in }, onSuccess: {_ in}, onError: {_ in}, onEmpty: {})
  }
  
  private func getTimes() {
    log.d {
        "-------Times-------\n" +
        "Parsing Time \(self.parsingTime)\n" +
        "Response to Entity Mapping Time \(self.responseToEntityMappingTime)\n" +
        "Entity Writing Time \(self.entityWritingTime)\n" +
        "Entity Reading Time \(self.entityReadingTime)\n" +
        "Entity to Domain Model Mapping Time \(self.entityToDomainModelMappingTime)"
    }
  }
  
  
}

//Parsing Time 696
//Response to Entity Mapping Time 10
//Entity Writing Time 0
//Entity Reading Time 12
//Entity to Domain Model Mapping Time 0

//Parsing Time 599
//Response to Entity Mapping Time 4
//Entity Writing Time 0
//Entity Reading Time 11
//Entity to Domain Model Mapping Time 0

//Parsing Time 534
//Response to Entity Mapping Time 3
//Entity Writing Time 0
//Entity Reading Time 9
//Entity to Domain Model Mapping Time 0

//Parsing Time 522
//Response to Entity Mapping Time 3
//Entity Writing Time 0
//Entity Reading Time 9
//Entity to Domain Model Mapping Time 0

//Parsing Time 587
//Response to Entity Mapping Time 3
//Entity Writing Time 0
//Entity Reading Time 12
//Entity to Domain Model Mapping Time 0






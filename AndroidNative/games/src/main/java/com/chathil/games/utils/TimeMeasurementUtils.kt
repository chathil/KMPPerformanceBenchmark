package com.chathil.games.utils

data class TimeMeasurementUtils(
    val parsingTimeStart: (Long) -> Unit,
    val parsingTimeEnd: (Long) -> Unit,
    val responseToEntityMappingTimeStart: (Long) -> Unit,
    val responseToEntityMappingTimeEnd: (Long) -> Unit,
    val entityWritingTimeStart: (Long) -> Unit,
    val entityWritingTimeEnd: (Long) -> Unit,
    val entityReadingTimeStart: (Long) -> Unit,
    val entityReadingTimeEnd: (Long) -> Unit,
    val entityToDomainModelMappingTimeStart: (Long) -> Unit,
    val entityToDomainModelMappingTimeEnd: (Long) -> Unit
)

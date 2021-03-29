package com.chathil.games.presentation

import android.util.Log
import com.chathil.games.domain.usecase.GetGamesInteractor
import com.chathil.games.utils.MainScope
import com.chathil.games.utils.TimeMeasurementUtils
import com.chathil.games.utils.collect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetGamesPresenter @Inject constructor(private val useCase: GetGamesInteractor) {

    private val scope = MainScope(Dispatchers.Main)
    @InternalCoroutinesApi
    fun getList(force: Boolean = true) {
        scope.launch {
            useCase.execute(force, timeMeasurementUtils).collect {
                Log.d(TAG, it.toString().length.toString())
            }
        }
    }

    private var parsingTimeStart = 0L
    private var parsingTime = 0

    private var responseToEntityMappingTimeStart = 0L
    private var responseToEntityMappingTime = 0

    private var entityWritingTimeStart = 0L
    private var entityWritingTime = 0

    private var entityReadingTimeStart = 0L
    private var entityReadingTime = 0

    private var entityToDomainModelMappingTimeStart = 0L
    private var entityToDomainModelMappingTime = 0

    private val timeMeasurementUtils = TimeMeasurementUtils(
        parsingTimeStart = {
            parsingTimeStart = it
            Log.i(TAG, "parsing: $it")
        },
        parsingTimeEnd = {
            parsingTime = (it - parsingTimeStart).toInt()
            Log.i(TAG, "parsingEnd: $it")
        },
        responseToEntityMappingTimeStart = { responseToEntityMappingTimeStart = it },
        responseToEntityMappingTimeEnd = {
            responseToEntityMappingTime = (it - responseToEntityMappingTimeStart).toInt()
        },
        entityWritingTimeStart = { entityWritingTimeStart = it },
        entityWritingTimeEnd = { entityWritingTime = (it - entityWritingTimeStart).toInt() },
        entityReadingTimeStart = { entityReadingTimeStart = it },
        entityReadingTimeEnd = { entityReadingTime = (it - entityReadingTimeStart).toInt() },
        entityToDomainModelMappingTimeStart = { entityToDomainModelMappingTimeStart = it },
        entityToDomainModelMappingTimeEnd = {
            entityToDomainModelMappingTime = (it - entityToDomainModelMappingTime).toInt()
        }
    )

    fun getTimes() {
        Log.d(TAG, "-------Times-------\n" +
                "Parsing Time $parsingTime\n" +
                "Response to Entity Mapping Time $responseToEntityMappingTime\n" +
                "Entity Writing Time $entityWritingTime\n" +
                "Entity Reading Time $entityReadingTime\n" +
                "Entity to Domain Model Mapping Time $entityToDomainModelMappingTime")
    }

    companion object {
        val TAG = GetGamesPresenter::class.java.simpleName
    }

}
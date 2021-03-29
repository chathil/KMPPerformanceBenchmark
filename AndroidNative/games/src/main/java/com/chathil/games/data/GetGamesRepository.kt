package com.chathil.games.data

import co.touchlab.kampkit.vo.DataState
import com.chathil.games.data.local.GetGamesLocalDataSource
import com.chathil.games.data.remote.GetGamesRemoteDataSource
import com.chathil.games.domain.model.GameModel
import com.chathil.games.transformer.toDomainModels
import com.chathil.games.transformer.toEntities
import com.chathil.games.utils.TimeMeasurementUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import javax.inject.Inject
import kotlin.concurrent.thread

class GetGamesRepository @Inject constructor(
    private val getGamesLocalDataSource: GetGamesLocalDataSource,
    private val getGamesRemoteDataSource: GetGamesRemoteDataSource,
) {
    private val clock: Clock.System = Clock.System
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

    fun execute(
        force: Boolean = false,
        timeMeasurementUtils: TimeMeasurementUtils
    ): Flow<DataState<List<GameModel>>> =
        networkBoundResource(
            query = {
                getGamesLocalDataSource.allGames()
                    .onStart {
                        timeMeasurementUtils.entityReadingTimeStart(
                            clock.now().toEpochMilliseconds()
                        )
                    }.onCompletion {
                        timeMeasurementUtils.entityReadingTimeEnd(clock.now().toEpochMilliseconds())
                    }.apply {
                        timeMeasurementUtils.entityToDomainModelMappingTimeStart(
                            clock.now().toEpochMilliseconds()
                        )
                    }.map {
                        it.toDomainModels()
                    }.apply {
                        timeMeasurementUtils.entityToDomainModelMappingTimeEnd(
                            clock.now().toEpochMilliseconds()
                        )
                    }

            },
            fetch = {
                timeMeasurementUtils.parsingTimeStart(clock.now().toEpochMilliseconds())
                return@networkBoundResource getGamesRemoteDataSource.execute().apply {
                    timeMeasurementUtils.parsingTimeEnd(clock.now().toEpochMilliseconds())

                }
            },
            saveFetchResult = {

                val entities = it.apply {
                    timeMeasurementUtils.responseToEntityMappingTimeStart(
                        clock.now().toEpochMilliseconds()
                    )

                }.toEntities().apply {
//                    Thread.sleep(500)
                    timeMeasurementUtils.responseToEntityMappingTimeEnd(
                        clock.now().toEpochMilliseconds()
                    )
                }

                timeMeasurementUtils.entityWritingTimeStart(clock.now().toEpochMilliseconds())
                withContext(defaultDispatcher) {
                    getGamesLocalDataSource.clearGames()
                    getGamesLocalDataSource.insertGames(
                        entities
                    ).apply {
//                        Thread.sleep(500)
                        timeMeasurementUtils.entityWritingTimeEnd(clock.now().toEpochMilliseconds())
                    }
                }
            },
            shouldFetch = { force || it.isEmpty() }
        )
}
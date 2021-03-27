package co.touchlab.kampkit.data

import co.touchlab.kampkit.data.local.GetGamesLocalDataSource
import co.touchlab.kampkit.data.remote.GetGamesRemoteDataSource
import co.touchlab.kampkit.domain.model.GameModel
import co.touchlab.kampkit.transformer.toDomainModels
import co.touchlab.kampkit.transformer.toEntities
import co.touchlab.kampkit.utils.TimeMeasurementUtils
import co.touchlab.kampkit.vo.DataState
import co.touchlab.kermit.Kermit
import kotlinx.coroutines.flow.*
import kotlinx.datetime.Clock
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class GetGamesRepository(
    private val getGamesLocalDataSource: GetGamesLocalDataSource,
    private val getGamesRemoteDataSource: GetGamesRemoteDataSource
) : KoinComponent {
    private val logger: Kermit by inject { parametersOf("GetGamesRepository") }
    private val clock: Clock by inject()

    fun execute(
        force: Boolean = false,
        timeMeasurementUtils: TimeMeasurementUtils
    ): Flow<DataState<List<GameModel>>> = networkBoundResource(
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
            getGamesLocalDataSource.clearGames()
            timeMeasurementUtils.entityWritingTimeStart(clock.now().toEpochMilliseconds())
            getGamesLocalDataSource.cacheGames(
                it.apply {
                    timeMeasurementUtils.responseToEntityMappingTimeStart(
                        clock.now().toEpochMilliseconds()
                    )

                }.toEntities().apply {
                    timeMeasurementUtils.responseToEntityMappingTimeEnd(
                        clock.now().toEpochMilliseconds()
                    )
                }
            ).apply {
                timeMeasurementUtils.entityWritingTimeEnd(clock.now().toEpochMilliseconds())
            }
        },
        shouldFetch = { force || it.isEmpty() }
    )


}
package co.touchlab.kampkit.domain.usecase

import co.touchlab.kampkit.data.GetGamesRepository
import co.touchlab.kampkit.domain.model.GameModel
import co.touchlab.kampkit.utils.TimeMeasurementUtils
import co.touchlab.kampkit.vo.DataState
import kotlinx.coroutines.flow.Flow

interface GamesUseCase {
    fun execute(force: Boolean = false, timeMeasurementUtils: TimeMeasurementUtils): Flow<DataState<List<GameModel>>>
}

class GamesInteractor(private val repository: GetGamesRepository): GamesUseCase {
    override fun execute(force: Boolean, timeMeasurementUtils: TimeMeasurementUtils) = repository.execute(force, timeMeasurementUtils)
}
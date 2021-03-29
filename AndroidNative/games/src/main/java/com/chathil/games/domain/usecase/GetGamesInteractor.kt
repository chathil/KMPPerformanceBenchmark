package com.chathil.games.domain.usecase

import com.chathil.games.domain.model.GameModel
import co.touchlab.kampkit.vo.DataState
import com.chathil.games.data.GetGamesRepository
import com.chathil.games.utils.TimeMeasurementUtils
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetGamesUseCase {
    fun execute(force: Boolean = false, timeMeasurementUtils: TimeMeasurementUtils): Flow<DataState<List<GameModel>>>
}

class GetGamesInteractor @Inject constructor(private val repository: GetGamesRepository): GetGamesUseCase {
    override fun execute(force: Boolean, timeMeasurementUtils: TimeMeasurementUtils) = repository.execute(force, timeMeasurementUtils)
}
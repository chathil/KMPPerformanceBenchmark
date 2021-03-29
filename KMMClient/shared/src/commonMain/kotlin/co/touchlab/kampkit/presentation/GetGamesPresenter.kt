package co.touchlab.kampkit.presentation

import co.touchlab.kampkit.domain.model.GameModel
import co.touchlab.kampkit.domain.usecase.GamesUseCase
import co.touchlab.kampkit.utils.MainScope
import co.touchlab.kampkit.utils.TimeMeasurementUtils
import co.touchlab.kampkit.vo.DataState
import co.touchlab.kermit.Kermit
import co.touchlab.stately.ensureNeverFrozen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import org.koin.core.Koin
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class GetGamesPresenter(
    private val useCase: GamesUseCase
) : KoinComponent {

    private val log: Kermit by inject { parametersOf("GamesPresenter") }
    private val scope = MainScope(Dispatchers.Main, log)

    init {
        ensureNeverFrozen()
    }

    fun getList(
        force: Boolean = true,
        timeMeasurementUtils: TimeMeasurementUtils,
        onLoading: (List<GameModel>?) -> Unit,
        onSuccess: (List<GameModel>) -> Unit,
        onError: (String) -> Unit,
        onEmpty: () -> Unit
    ) {

        scope.launch {
            log.v { "Exposing flow through callbacks" }
            useCase.execute(force, timeMeasurementUtils).collect { dataState ->
                when (dataState) {
                    is DataState.Success -> {
                        onSuccess(dataState.data)
                    }
                    is DataState.Error -> {
                        onError(dataState.exception)
                    }
                    is DataState.Loading -> {
                        onLoading(dataState.data)
                    }
                    DataState.Empty -> {
                        onEmpty()
                    }
                }
            }
        }

    }

    fun onDestroy() {
        scope.onDestroy()
    }
}

package co.touchlab.kampkit.data

import co.touchlab.kampkit.vo.DataState
import kotlinx.coroutines.flow.*

internal inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline onFetchFailed: (Throwable) -> Unit = { },
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {
    emit(DataState.Loading(null))
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(DataState.Loading(data))
        try {
            saveFetchResult(fetch())
            query().map { DataState.Success(it) }
        } catch (throwable: Throwable) {
            onFetchFailed(throwable)
            query().map { DataState.Error(throwable.message ?: "Unknown Error") }
        }
    } else {
        query().map { DataState.Success(it) }
    }

    emitAll(flow)
}
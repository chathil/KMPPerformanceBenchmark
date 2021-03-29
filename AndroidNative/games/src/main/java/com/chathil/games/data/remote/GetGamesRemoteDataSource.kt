package com.chathil.games.data.remote

import javax.inject.Inject

@OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)
class GetGamesRemoteDataSource @Inject constructor() {
    suspend fun execute() =
        GetGamesApi.appPrimaryService.execute()
}
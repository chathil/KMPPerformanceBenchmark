package com.chathil.games.data.remote

import com.chathil.games.data.remote.response.GameResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

val contentType = MediaType.parse("application/json")!!
@ExperimentalSerializationApi
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("http://10.0.2.2:8080/")
    .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(contentType))
    .build()

interface GetGamesService {
    @GET("games")
    suspend fun execute(): List<GameResponse>
}

object GetGamesApi {
    @ExperimentalSerializationApi
    val appPrimaryService: GetGamesService by lazy {
        retrofit.create(
            GetGamesService::class.java
        )
    }
}
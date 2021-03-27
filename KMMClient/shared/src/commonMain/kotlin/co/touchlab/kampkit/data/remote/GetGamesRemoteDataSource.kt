package co.touchlab.kampkit.data.remote

import co.touchlab.kampkit.data.remote.response.GameResponse
import co.touchlab.kampkit.utils.LocalHostURLUtils
import co.touchlab.kermit.Kermit
import co.touchlab.stately.ensureNeverFrozen
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import org.koin.core.KoinComponent
import org.koin.core.get

class GetGamesRemoteDataSource(
    private val baseUrl: String = LocalHostURLUtils().baseUrl,
    log: Kermit
) : KoinComponent {

    // If this is a constructor property, then it gets captured
    // inside HttpClient config and freezes this whole class.
    @Suppress("CanBePrimaryConstructorProperty")
    private val log = log

    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json = json)

        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    log.v("Network") { message }
                }
            }

            level = LogLevel.INFO
        }
    }


    init {
        ensureNeverFrozen()
    }

    suspend fun execute() = httpClient.get<List<GameResponse>>("$baseUrl/games")
}
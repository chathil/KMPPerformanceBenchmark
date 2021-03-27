package co.touchlab.kampkit.data.local

import co.touchlab.kampkit.data.local.entity.*
import co.touchlab.kampkit.utils.TimeMeasurementUtils
import co.touchlab.kermit.Kermit
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.datetime.Clock
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetGamesLocalDataSource(
    sqlDriver: SqlDriver,
    private val log: Kermit,
    private val backgroundDispatcher: CoroutineDispatcher
): KoinComponent {
    private val gameAdapter = GameEntity.Adapter(
        listOfRatingsAdapter,
        listOfGamePlatformAdapter,
        listOfParentPlatformAdapter,
        listOfGenreAdapter,
        listOfGameStoreAdapter,
        listOfTagAdapter,
        listOfShortScreenshotAdapter
    )
    private val clock: Clock by inject()
    private val dbRef: GamesLocalDb = GamesLocalDb(sqlDriver, gameAdapter)

    internal fun allGames(): Flow<List<GameEntity>> =
        dbRef.gamesLocalDataSourceQueries.loadGames().asFlow()
            .mapToList()
            .flowOn(backgroundDispatcher)

    internal fun clearGames() {
        dbRef.gamesLocalDataSourceQueries.clearGames()
    }

    internal suspend fun cacheGames(
        games: List<GameEntity>
    ) {
        dbRef.transactionWithContext(backgroundDispatcher) {
            games.forEach { game ->
                dbRef.gamesLocalDataSourceQueries.insertGame(
                    game.apiId,
                    game.name,
                    game.slug,
                    game.released,
                    game.tba,
                    game.backgroundImage,
                    game.rating,
                    game.ratingTop,
                    game.ratings,
                    game.ratingsCount,
                    game.reviewTextCount,
                    game.added,
                    game.metacritic,
                    game.playtime,
                    game.suggestionCount,
                    game.reviewsCount,
                    game.saturatedColor,
                    game.dominantColor,
                    game.platforms,
                    game.parentPlatforms,
                    game.genres,
                    game.stores,
                    game.clip,
                    game.tags,
                    game.shortScreenshots
                )
            }
        }
    }
}
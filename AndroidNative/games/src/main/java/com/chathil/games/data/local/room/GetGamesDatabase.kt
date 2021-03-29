package com.chathil.games.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chathil.games.data.local.entity.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GetGamesDatabaseModule {

    @Provides
    fun providesGetGamesDao(appDatabase: GetGamesDatabase): GetGamesDao {
        return appDatabase.dao
    }

    @Provides
    @Singleton
    fun getGetGamesDatabase(@ApplicationContext context: Context): GetGamesDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            GetGamesDatabase::class.java,
            "get_games_db"
        ).build()
    }
}



@Database(
    entities = [GameEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    ParentPlatformEntityConverter::class,
    GamePlatformEntityConverter::class,
    GameStoreEntityConverter::class,
    GenreEntityConverter::class,
    RatingEntityConverter::class,
    ShortScreenshotEntityConverter::class,
    TagEntityConverter::class
)

abstract class GetGamesDatabase : RoomDatabase() {
    abstract val dao: GetGamesDao
}
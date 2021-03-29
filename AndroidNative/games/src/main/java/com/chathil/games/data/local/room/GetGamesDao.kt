package com.chathil.games.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chathil.games.data.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GetGamesDao {
    @Query("SELECT * FROM game_entity")
    fun loadGames(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGames(games: List<GameEntity>)

    @Query("DELETE FROM game_entity")
    fun clearGames()
}
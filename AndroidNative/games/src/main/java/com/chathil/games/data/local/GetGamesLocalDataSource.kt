package com.chathil.games.data.local

import com.chathil.games.data.local.entity.GameEntity
import com.chathil.games.data.local.room.GetGamesDao
import javax.inject.Inject

class GetGamesLocalDataSource @Inject constructor(private val dao: GetGamesDao) {
    fun insertGames(games: List<GameEntity>) = dao.insertGames(games)
    fun allGames() = dao.loadGames()
    fun clearGames() = dao.clearGames()
}
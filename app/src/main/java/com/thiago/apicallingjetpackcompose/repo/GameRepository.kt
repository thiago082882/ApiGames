package com.thiago.apicallingjetpackcompose.repo

import android.util.Log
import com.thiago.apicallingjetpackcompose.data.remote.GameService
import com.thiago.apicallingjetpackcompose.domain.items.GameItem
import com.thiago.apicallingjetpackcompose.domain.items.SpecificGameItem
import com.thiago.apicallingjetpackcompose.domain.items.toGameItem
import com.thiago.apicallingjetpackcompose.domain.items.toSpecificGameItem
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameService: GameService)  {

    suspend fun getGames(): List<GameItem> {
        Log.d("GameRepository", "getGames() called")
        val games = gameService.getGames()
        Log.d("GameRepository", "getGames() returned: $games")
        return gameService.getGames().map {
            it.toGameItem()
        }

    }

    suspend fun getGameById(id: Int): SpecificGameItem {
        Log.d("GameRepository", "getGameById() called with id: $id")
        return gameService.getGameById(id).toSpecificGameItem()

    }
}
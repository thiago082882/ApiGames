package com.thiago.apicallingjetpackcompose.data.remote

import com.thiago.apicallingjetpackcompose.data.models.GameModel
import com.thiago.apicallingjetpackcompose.data.models.SpecificGameModel
import com.thiago.apicallingjetpackcompose.util.Constants.Companion.GAMES_ENDPOINT
import com.thiago.apicallingjetpackcompose.util.Constants.Companion.GAME_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>

    @GET(GAME_ID_ENDPOINT)
    suspend fun getGameById(@Query(value = "id") id: Int): Response<SpecificGameModel>
}
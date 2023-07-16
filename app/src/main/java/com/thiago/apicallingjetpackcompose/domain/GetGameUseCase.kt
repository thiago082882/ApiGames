package com.thiago.apicallingjetpackcompose.domain

import com.thiago.apicallingjetpackcompose.domain.items.GameItem
import com.thiago.apicallingjetpackcompose.repo.GameRepository
import javax.inject.Inject

class GetGameUseCase  @Inject constructor(private val gameRepository: GameRepository){

    suspend operator fun invoke(): List<GameItem> {

        return gameRepository.getGames().shuffled()

    }

}
package com.thiago.apicallingjetpackcompose.domain

import com.thiago.apicallingjetpackcompose.domain.items.SpecificGameItem
import com.thiago.apicallingjetpackcompose.repo.GameRepository
import javax.inject.Inject

class GetGameByIdUseCase  @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(id: Int): SpecificGameItem {

        return gameRepository.getGameById(id)

    }
}
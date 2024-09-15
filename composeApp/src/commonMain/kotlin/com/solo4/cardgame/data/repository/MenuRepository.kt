package com.solo4.cardgame.data.repository

import com.solo4.cardgame.data.base.ApiResult
import com.solo4.cardgame.data.service.GameService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class MenuRepository(private val gameService: GameService) {

    fun openGameConnection(): Flow<ApiResult> {
        return gameService.openWebSocketConnection()
            .flowOn(Dispatchers.IO)
    }

    suspend fun connectToLobby(userName: String) {
        withContext(Dispatchers.IO) {
            gameService.joinToLobby(userName)
        }
    }
}
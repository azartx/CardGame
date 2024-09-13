package com.solo4.cardgame.data.repository

import com.solo4.cardgame.data.service.GameService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.koin.mp.KoinPlatformTools

class MenuRepository(private val gameService: GameService) {

    suspend fun openGameConnection() {
        withContext(Dispatchers.IO) {
            gameService.openWebSocketConnection()
        }
    }

    suspend fun connectToLobby(userName: String) {
        withContext(Dispatchers.IO) {
            gameService.joinToLobby(userName)
        }
    }

    // TODO debug only, RM
    suspend fun emulateOtherConnections() {
        withContext(Dispatchers.IO) {
            repeat(3) {
                GameService(KoinPlatformTools.defaultContext().get().get()).apply {
                    openWebSocketConnection()
                    delay(200)
                    joinToLobby("player $it")
                }
            }
        }

    }
}
package com.solo4.cardgame.data.service

import com.solo4.cardgame.data.base.ApiResult
import com.solo4.cardgame.data.model.GameCommandDeserializer
import com.solo4.cardgame.data.model.gamecommands.CommandData
import com.solo4.cardgame.data.model.gamecommands.InitCommandData
import com.solo4.cardgame.data.model.gamecommands.toGameCommand
import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
import io.ktor.client.plugins.websocket.WebSocketException
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.http.HttpMethod
import io.ktor.websocket.close
import io.ktor.websocket.send
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class GameService(private val client: HttpClient) {

    private var session: DefaultClientWebSocketSession? = null

    fun openWebSocketConnection(): Flow<ApiResult> {
        return flow {
            try {
                client.webSocket(
                    method = HttpMethod.Get,
                    host = "192.168.100.15",
                    port = 13255,
                ) {
                    session = this
                    while (true) {
                        val frame = incoming.receive()
                        val json = String(frame.data)
                        if (json.contains("PING")) {
                            send("{\"Command\":\"PONG\"}")
                        } else {
                            emit(ApiResult.Success(GameCommandDeserializer.deserializeGameCommand(String(frame.data))))
                        }
                    }
                }
            } catch (e: Throwable) {
                e.printStackTrace()
                emit(ApiResult.Failure.Other(e))
            } finally {
                session = null
            }
        }
    }

    suspend fun joinToLobby(playerName: String): ApiResult {
        return session?.let { currentSession ->
            try {
                currentSession.send(Json.encodeToString(InitCommandData(playerName).toGameCommand()))
                ApiResult.Success()
            } catch (e: Exception) {
                e.printStackTrace()
                ApiResult.Failure.Other(e)
            }
        } ?: ApiResult.Failure.WebSocketWasClosed
    }

    suspend fun sendGameEvent(event: CommandData): Result<String> {
        return session?.takeIf { it.isActive }?.let { webSocketSession ->
            try {
                webSocketSession.send(Json.encodeToString(event.toGameCommand()))
                Result.success("")
            } catch (e: Throwable) {
                closeSession()
                Result.failure(WebSocketException("Session was closed"))
            }
        } ?: run {
            closeSession()
            Result.failure(WebSocketException("Session was closed"))
        }
    }

    private suspend fun closeSession() {
        session?.close()
        session = null
    }
}
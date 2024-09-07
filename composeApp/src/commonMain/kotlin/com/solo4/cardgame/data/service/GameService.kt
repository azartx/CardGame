package com.solo4.cardgame.data.service

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
import io.ktor.client.plugins.websocket.WebSocketException
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.http.HttpMethod
import io.ktor.websocket.Frame
import io.ktor.websocket.close
import io.ktor.websocket.readText
import io.ktor.websocket.send
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive

class GameService(private val client: HttpClient) {

    private var session: DefaultClientWebSocketSession? = null

    suspend fun openWebSocketConnection(): Flow<Any> {
        return flow {
            client.webSocket(
                method = HttpMethod.Get,
                host = "TODO HOST",
                port = null,
                path = "",
                request = {}
            ) {
                session = this
                try {
                    val response = (incoming.receive() as? Frame.Text)?.readText()
                    incoming.receive()
                    if (response != null) {
                        emit(response)
                    }
                } finally {
                    session = null
                    this.close()
                }
            }
        }
    }

    suspend fun sendGameEvent(event: String): Result<String> {
        return session?.takeIf { it.isActive }?.let { webSocketSession ->
            try {
                webSocketSession.send(event)
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
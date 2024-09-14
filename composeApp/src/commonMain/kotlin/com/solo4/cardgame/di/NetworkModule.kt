package com.solo4.cardgame.di

import com.solo4.cardgame.data.model.GameCommandDeserializer
import com.solo4.cardgame.data.service.GameService
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.websocket.WebSockets
import org.koin.dsl.module

internal val networkModule = module {
    single {
        HttpClient(CIO) {
            install(WebSockets)
        }
    }

    single { GameCommandDeserializer() }

    factory { GameService(get(), get()) }
}
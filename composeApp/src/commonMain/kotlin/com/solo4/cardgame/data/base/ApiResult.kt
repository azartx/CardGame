package com.solo4.cardgame.data.base

import com.solo4.cardgame.data.model.GameCommand
import com.solo4.cardgame.data.model.gamecommands.CommandData

sealed interface ApiResult {

    data class Success(val data: GameCommand<out CommandData>? = null) : ApiResult

    sealed interface Failure : ApiResult {

        data object WebSocketWasClosed : Failure

        data class Other(val throwable: Throwable) : Failure
    }
}
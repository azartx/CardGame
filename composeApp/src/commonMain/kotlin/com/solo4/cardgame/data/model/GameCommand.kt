package com.solo4.cardgame.data.model

import com.solo4.cardgame.data.model.gamecommands.CommandData

data class GameCommand<T : CommandData>(
    val commandType: String,
    val data: T
)
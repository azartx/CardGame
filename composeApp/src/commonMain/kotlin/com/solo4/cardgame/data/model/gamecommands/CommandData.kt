package com.solo4.cardgame.data.model.gamecommands

import com.solo4.cardgame.data.model.GameCommand

interface CommandData {

    val type: String
}

fun <T : CommandData> T.toGameCommand(): GameCommand<in T> {
    return GameCommand(
        commandType = type,
        data = this
    )
}
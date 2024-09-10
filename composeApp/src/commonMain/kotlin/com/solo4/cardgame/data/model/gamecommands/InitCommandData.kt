package com.solo4.cardgame.data.model.gamecommands

data class InitCommandData(
    val playerId: String,
    val playerName: String,
    override val type: String = "INIT"
) : CommandData

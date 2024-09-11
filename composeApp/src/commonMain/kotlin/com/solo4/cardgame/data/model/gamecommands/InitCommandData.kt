package com.solo4.cardgame.data.model.gamecommands

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class InitCommandData @OptIn(ExperimentalUuidApi::class) constructor(
    val playerName: String,
    val playerId: String = Uuid.random().toHexString(),
    override val type: String = "INIT"
) : CommandData

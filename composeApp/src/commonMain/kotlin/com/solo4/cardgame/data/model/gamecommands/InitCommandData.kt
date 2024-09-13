package com.solo4.cardgame.data.model.gamecommands

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
data class InitCommandData @OptIn(ExperimentalUuidApi::class) constructor(
    val playerName: String,
    val playerId: String = Uuid.random().toHexString(),
    override val type: String = "INIT"
) : CommandData

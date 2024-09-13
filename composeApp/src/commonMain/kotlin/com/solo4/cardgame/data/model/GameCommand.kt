package com.solo4.cardgame.data.model

import com.solo4.cardgame.data.model.gamecommands.CommandData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameCommand<T : CommandData>(
    @SerialName("Command")
    val commandType: String,
    @SerialName("Data")
    val data: T
)
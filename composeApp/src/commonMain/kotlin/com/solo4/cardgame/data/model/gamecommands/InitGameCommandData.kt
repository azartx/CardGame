package com.solo4.cardgame.data.model.gamecommands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
data class InitGameCommandData(
    @SerialName("countPlayers")
    val countPlayers: String,
    @SerialName("player1Name")
    val player1Name: String,
    @SerialName("player1Id")
    val player1Id: String,
    @SerialName("player1Role")
    val player1Role: String,
    @SerialName("player2Name")
    val player2Name: String,
    @SerialName("player2Id")
    val player2Id: String,
    @SerialName("player2Role")
    val player2Role: String,
    @SerialName("player3Name")
    val player3Name: String,
    @SerialName("player3Id")
    val player3Id: String,
    @SerialName("player3Role")
    val player3Role: String,
    @SerialName("player4Name")
    val player4Name: String,
    @SerialName("player4Id")
    val player4Id: String,
    @SerialName("player4Role")
    val player4Role: String,
    @SerialName("smallBlind")
    val smallBlind: String,
    @SerialName("bigBlind")
    val bigBlind: String,
    @Transient
    override val type: String = "INIT_GAME"
) : CommandData

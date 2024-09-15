package com.solo4.cardgame.data.model.gamecommands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
data class AddGoldsCommandData(
    @SerialName("quantity")
    val quantity: String,
    @Transient
    override val type: String = "ADD_GOLDS"
) : CommandData

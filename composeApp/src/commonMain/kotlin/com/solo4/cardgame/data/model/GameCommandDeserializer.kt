package com.solo4.cardgame.data.model

import com.solo4.cardgame.data.model.gamecommands.AddCardsCommandData
import com.solo4.cardgame.data.model.gamecommands.AddGoldsCommandData
import com.solo4.cardgame.data.model.gamecommands.InitGameCommandData
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object GameCommandDeserializer {

    fun deserializeGameCommand(json: String): GameCommand<*> {
        val jsonMap = Json.parseToJsonElement(json).jsonObject.toMap()

        val command = jsonMap["Command"]!!.jsonPrimitive.content

        return when (command.lowercase()) {
            "init_game" -> Json.decodeFromString<GameCommand<InitGameCommandData>>(json)
            "add_cards" -> Json.decodeFromString<GameCommand<AddCardsCommandData>>(json)
            "add_golds" -> Json.decodeFromString<GameCommand<AddGoldsCommandData>>(json)
            else -> throw IllegalArgumentException()
        }
    }
}
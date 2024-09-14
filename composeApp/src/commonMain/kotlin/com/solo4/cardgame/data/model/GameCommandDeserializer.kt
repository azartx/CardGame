package com.solo4.cardgame.data.model

import com.solo4.cardgame.data.model.gamecommands.CommandData
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

// TODO
class GameCommandDeserializer : KSerializer<GameCommand<out CommandData>> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("GameCommand") {

    }

    override fun deserialize(decoder: Decoder): GameCommand<out CommandData> {
        throw NotImplementedError()
    }

    override fun serialize(encoder: Encoder, value: GameCommand<out CommandData>) {

    }
}
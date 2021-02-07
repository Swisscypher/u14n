package ch.swisscypher.u14n.common.config

import ch.swisscypher.u14n.common.ResourceFile
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

val config by lazy {
    val file = ResourceFile.config
    val input = file.inputStream()

    Json.decodeFromString(Config.serializer(), input.bufferedReader().use { it.readText() })
}

@Serializable
data class Config(val `default-head`: String, val `default-language`: String)

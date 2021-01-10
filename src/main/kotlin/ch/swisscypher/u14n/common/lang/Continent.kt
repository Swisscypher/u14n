package ch.swisscypher.u14n.common.lang

import ch.swisscypher.u14n.common.ResourceFile
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonTransformingSerializer

@Serializable
data class Continent(val name: String, val countries: List<Country>) {
    companion object {
        val continents: List<Continent> by lazy {
            Json.decodeFromString(ContinentListSerializer, ResourceFile.languages.readText())
        }
    }
}

object ContinentListSerializer: JsonTransformingSerializer<List<Continent>>(ListSerializer(Continent.serializer())) {
    override fun transformDeserialize(element: JsonElement): JsonElement =
        if(element !is JsonArray) JsonArray(listOf(element)) else element
}


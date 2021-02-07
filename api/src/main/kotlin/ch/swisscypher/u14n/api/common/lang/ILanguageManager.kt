package ch.swisscypher.u14n.api.common.lang

import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonTransformingSerializer

interface ILanguageManager {
    fun registerEntry(e: Entry)
    fun getEntry(key: String): String
}

@Serializable
data class Entry(val key: String, val value: String)

object EntryListSerializer: JsonTransformingSerializer<List<Entry>>(ListSerializer(Entry.serializer())) {
    override fun transformDeserialize(element: JsonElement): JsonElement =
        if(element !is JsonArray) JsonArray(listOf(element)) else element
}

package ch.swisscypher.u14n.api.common.lang

import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonTransformingSerializer

/**
 * A class representing a language manager for a given plugin and a given language
 */
interface ILanguageManager {
    fun registerEntry(e: Entry)
    fun getEntry(key: String): String
}

/**
 * A language entry, with its key and value
 */
@Serializable
data class Entry(val key: String, val value: String)

/**
 * Serializer used to serialise the entries
 */
object EntryListSerializer: JsonTransformingSerializer<List<Entry>>(ListSerializer(Entry.serializer())) {
    override fun transformDeserialize(element: JsonElement): JsonElement =
        if(element !is JsonArray) JsonArray(listOf(element)) else element
}

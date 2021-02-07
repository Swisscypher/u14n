/*
 * Copyright 2021 Comore, Zayceur
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

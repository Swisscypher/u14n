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

package ch.swisscypher.u14n.common

import ch.swisscypher.u14n.api.common.lang.ILanguage
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonTransformingSerializer

class LanguageManager(val language: ILanguage) {
    private val values: MutableMap<String, String> = HashMap()

    fun registerEntry(e: Entry) {
        values[e.key] = e.value
    }

    fun getEntry(key: String): String {
        return values[key] ?: "{$key}"
    }
}

@Serializable
data class Entry(val key: String, val value: String)

object EntryListSerializer: JsonTransformingSerializer<List<Entry>>(ListSerializer(Entry.serializer())) {
    override fun transformDeserialize(element: JsonElement): JsonElement =
        if(element !is JsonArray) JsonArray(listOf(element)) else element
}

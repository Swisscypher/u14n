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


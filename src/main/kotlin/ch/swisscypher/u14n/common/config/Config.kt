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

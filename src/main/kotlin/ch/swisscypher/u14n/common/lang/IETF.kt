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

import java.util.*

// Languages that a plugin can provide
val languages: Set<Locale> by lazy {
    Continent.continents.flatMap { it.countries }
        .flatMap { it.languages }
        .map { Locale.forLanguageTag(it) }
        .flatMap {
            listOf(it, getParent(it)) }
        .toSet()
}

fun getParent(l: Locale) = Locale(l.language)
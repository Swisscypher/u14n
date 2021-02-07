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

import ch.swisscypher.u14n.api.common.ICountry
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Country(
    override val countryCode: String,
    override val languages: List<String>,
    val head: String = "DEFAULT"
): Comparable<Country>, ICountry {
    @Contextual
    private val localeCountry = Locale("", countryCode)

    companion object {
        val countries by lazy {
            Continent.continents.flatMap { it.countries }
        }
    }

    fun getDisplayName(locale: Locale): String {
        return localeCountry.getDisplayCountry(locale)
    }

    override fun compareTo(other: Country): Int {
        return countryCode.compareTo(other.countryCode)
    }
}
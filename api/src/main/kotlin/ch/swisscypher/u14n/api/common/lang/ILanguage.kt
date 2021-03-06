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

import java.util.*

/**
 * Represent a language
 */
interface ILanguage {
    val language: String
    val country: String
    val parent: Optional<ILanguage>
    val locale: Locale

    /**
     * @return The IETF code of the given language
     */
    fun toIETFCode(): String

    companion object {
        fun fromLocale(locale: Locale): ILanguage {
            val lang = ClassLoader.getSystemClassLoader().loadClass("ch.swisscypher.u14n.common.lang.Language")
            return lang.getConstructor(Locale::class.java).newInstance(locale) as ILanguage
        }
    }
}
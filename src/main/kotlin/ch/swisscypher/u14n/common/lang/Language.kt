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

import ch.swisscypher.u14n.api.common.ILanguage
import java.util.*
import kotlin.collections.HashSet

class Language(
    override val locale: Locale
) : ILanguage {
    override val language: String
        get() = locale.language
    override val country: String
        get() = locale.country
    override val parent: Optional<ILanguage>
        get() = if(locale.country.isNotEmpty()) Optional.of(Language(Locale.forLanguageTag(language))) else Optional.empty()

    override fun toIETFCode(): String {
        return locale.toLanguageTag()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Language

        if (locale != other.locale) return false

        return true
    }

    override fun hashCode(): Int {
        return locale.hashCode()
    }


    companion object {
        fun findBestLanguage(
            playerLanguage: ILanguage,
            configDefaultLanguage: ILanguage,
            pluginDefaultLanguage: ILanguage,
            supportedLanguages: HashSet<ILanguage>
        ): Optional<ILanguage> {
            if(supportedLanguages.contains(playerLanguage))
                return Optional.of(playerLanguage)

            if(playerLanguage.parent.isPresent)
                return findBestLanguage(
                    playerLanguage.parent.get(),
                    configDefaultLanguage,
                    pluginDefaultLanguage,
                    supportedLanguages
                )

            if(supportedLanguages.contains(configDefaultLanguage))
                return Optional.of(configDefaultLanguage)

            if(supportedLanguages.contains(pluginDefaultLanguage))
                return Optional.of(pluginDefaultLanguage)

            return Optional.empty()
        }
    }
}
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

class LanguageFormatter(val pluginName: String, val prefix: String = "{", val suffix: String = "}") {

    companion object {
        fun format(pluginName: String, lang: ILanguage, key: String, prefix: String = "{", suffix: String = "}"): String {
            val langManager = PluginManager.getLangManager(pluginName, lang)

            if(!langManager.isPresent)
                return key

            return Formatter.format(lang, prefix, suffix, langManager.get().getEntry(key))
        }
    }

    fun format(lang: ILanguage, key: String): String {
        return format(pluginName, lang, key, prefix, suffix)
    }
}
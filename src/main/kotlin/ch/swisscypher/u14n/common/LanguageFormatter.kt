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
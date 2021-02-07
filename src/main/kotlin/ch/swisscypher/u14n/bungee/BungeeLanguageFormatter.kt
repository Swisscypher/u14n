package ch.swisscypher.u14n.bungee

import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.common.Formatter
import net.md_5.bungee.api.plugin.Plugin

class BungeeLanguageFormatter(val plugin: Plugin, val prefix: String = "{", val suffix: String = "}") {
    companion object {
        fun format(plugin: Plugin, lang: ILanguage, key: String, prefix: String = "{", suffix: String = "}"): String {
            val langManager = BungeePluginManager.getLangManager(plugin, lang)

            if(!langManager.isPresent)
                return key

            return Formatter.format(lang, prefix, suffix, langManager.get().getEntry(key))
        }
    }

    fun format(lang: ILanguage, key: String): String {
        return format(plugin, lang, key, prefix, suffix)
    }
}
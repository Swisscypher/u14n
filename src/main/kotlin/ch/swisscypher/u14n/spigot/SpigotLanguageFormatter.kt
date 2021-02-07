package ch.swisscypher.u14n.spigot

import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.common.Formatter
import org.bukkit.plugin.java.JavaPlugin

class SpigotLanguageFormatter(val plugin: JavaPlugin, val prefix: String = "{", val suffix: String = "}") {
    companion object {
        fun format(plugin: JavaPlugin, lang: ILanguage, key: String, prefix: String = "{", suffix: String = "}"): String {
            val langManager = SpigotPluginManager.getLangManager(plugin, lang)

            if(!langManager.isPresent)
                return key

            return Formatter.format(lang, prefix, suffix, langManager.get().getEntry(key))
        }
    }

    fun format(lang: ILanguage, key: String): String {
        return format(plugin, lang, key, prefix, suffix)
    }
}
package ch.swisscypher.u14n.bungee

import ch.swisscypher.u14n.api.bungee.IPluginManager
import ch.swisscypher.u14n.api.common.lang.ILanguageManager
import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.common.PluginManager
import net.md_5.bungee.api.plugin.Plugin
import java.io.InputStream
import java.util.*

object BungeePluginManager: IPluginManager {
    override fun registerPlugin(plugin: Plugin) {
        PluginManager.registerPlugin(plugin.description.name)
    }

    override fun registerFile(plugin: Plugin, input: InputStream, lang: ILanguage) {
        PluginManager.registerFile(plugin.description.name, input, lang)
    }

    override fun getLangManager(plugin: Plugin, lang: ILanguage): Optional<ILanguageManager> {
        return PluginManager.getLangManager(plugin.description.name, lang)
    }
}
package ch.swisscypher.u14n.spigot

import ch.swisscypher.u14n.api.common.lang.ILanguageManager
import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.api.spigot.IPluginManager
import ch.swisscypher.u14n.common.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import java.io.InputStream
import java.util.*

object SpigotPluginManager: IPluginManager {
    override fun registerPlugin(plugin: JavaPlugin) {
        PluginManager.registerPlugin(plugin.description.name)
    }

    override fun registerFile(plugin: JavaPlugin, input: InputStream, lang: ILanguage) {
        PluginManager.registerFile(plugin.description.name, input, lang)
    }

    override fun getLangManager(plugin: JavaPlugin, lang: ILanguage): Optional<ILanguageManager> {
        return PluginManager.getLangManager(plugin.description.name, lang)
    }
}
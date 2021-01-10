package ch.swisscypher.u14n.spigot

import ch.swisscypher.u14n.common.ResourceFile
import ch.swisscypher.u14n.common.lang.languages
import org.bukkit.Server
import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.PluginLoader
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.JavaPluginLoader
import java.io.File

class Main: JavaPlugin {

    companion object {
        lateinit var instance: Main
    }

    constructor() : super() {
        instance = this
    }

    constructor(loader: PluginLoader, server: Server, description: PluginDescriptionFile, dataFolder: File, file: File) : super(loader, server, description, dataFolder, file) {
        instance = this
    }

    constructor(loader: JavaPluginLoader, description: PluginDescriptionFile, dataFolder: File, file: File) : super(loader, description, dataFolder, file) {
        instance = this
    }

    override fun onEnable() {
        logger.info("Starting ${description.name} v${description.version}...")
        ResourceFile.init(dataFolder)



        println(languages)
    }
}
package ch.swisscypher.u14n.bungee

import ch.swisscypher.u14n.common.ResourceFile
import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.plugin.Plugin
import net.md_5.bungee.api.plugin.PluginDescription

class Main: Plugin {

    companion object {
        lateinit var instance: Main
    }

    constructor() : super() {
        instance = this
    }

    constructor(proxy: ProxyServer, description: PluginDescription) : super(proxy, description) {
        instance = this
    }

    override fun onEnable() {
        logger.info("Starting ${description.name} v${description.version}...")
        ResourceFile.init(dataFolder)
    }
}
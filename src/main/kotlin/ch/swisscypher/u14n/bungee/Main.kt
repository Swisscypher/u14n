package ch.swisscypher.u14n.bungee

import net.md_5.bungee.api.plugin.Plugin

class Main: Plugin() {
    override fun onEnable() {
        logger.info("Starting ${description.name} v${description.version}...")
    }
}
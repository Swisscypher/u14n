package ch.swisscypher.u14n.spigot

import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {
    override fun onEnable() {
        logger.info("Starting ${description.name} v${description.version}...")
    }
}
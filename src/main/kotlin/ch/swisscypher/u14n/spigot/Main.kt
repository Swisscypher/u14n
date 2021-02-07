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
    }
}
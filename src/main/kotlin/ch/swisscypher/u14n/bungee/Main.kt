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

package ch.swisscypher.u14n.bungee

import ch.swisscypher.u14n.api.bungee.IPluginManager
import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.common.PluginManager
import ch.swisscypher.u14n.common.ResourceFile
import ch.swisscypher.u14n.common.storage.StoragePlayer
import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.plugin.Plugin
import net.md_5.bungee.api.plugin.PluginDescription
import java.io.File
import java.util.*

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
        StoragePlayer.init(File(dataFolder, "player"))
        PluginManager.init(File(dataFolder, "language"))


    }
}
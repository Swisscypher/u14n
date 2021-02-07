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

import ch.swisscypher.u14n.api.common.lang.ILanguageManager
import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.api.spigot.IPluginManager
import ch.swisscypher.u14n.common.PluginManager
import net.md_5.bungee.api.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.io.InputStream
import java.util.*

object SpigotPluginManager: IPluginManager {
    override fun registerPlugin(plugin: JavaPlugin, defaultLanguage: ILanguage) {
        PluginManager.registerPlugin(plugin.description.name, defaultLanguage)
    }

    override fun registerFile(plugin: JavaPlugin, input: InputStream, lang: ILanguage) {
        PluginManager.registerFile(plugin.description.name, input, lang)
    }

    override fun getLangManager(plugin: JavaPlugin, lang: ILanguage): Optional<ILanguageManager> {
        return PluginManager.getLangManager(plugin.description.name, lang)
    }
}
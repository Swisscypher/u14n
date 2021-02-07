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

package ch.swisscypher.u14n.api.spigot

import ch.swisscypher.u14n.api.common.lang.ILanguageManager
import ch.swisscypher.u14n.api.common.lang.ILanguage
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.InputStream
import java.util.*

/**
 * Class you can use to register your spigot plugin and your language files
 */
interface IPluginManager {
    /**
     * @param plugin The plugin you are actually developing
     */
    fun registerPlugin(plugin: JavaPlugin)

    /**
     * @param plugin The plugin you are actually developing
     * @param input The input stream of the file
     * @param lang The language of the file
     */
    fun registerFile(plugin: JavaPlugin, input: InputStream, lang: ILanguage)

    /**
     * @param plugin The plugin you are actually developing
     * @param lang The language you want the manager
     * @return The {@link ch.swisscypher.u14n.api.common.lang.ILanguageManager} of the given plugin and language (empty if doesn't exist)
     */
    fun getLangManager(plugin: JavaPlugin, lang: ILanguage): Optional<ILanguageManager>

    companion object  {
        val pluginManager = Bukkit.getServicesManager().load(IPluginManager::class.java)
    }
}
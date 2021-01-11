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

import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.api.spigot.IPluginManager
import ch.swisscypher.u14n.common.EntryListSerializer
import ch.swisscypher.u14n.common.LanguageManager
import ch.swisscypher.u14n.common.exception.PluginNotRegisteredException
import com.google.common.io.ByteStreams
import kotlinx.serialization.json.Json
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

object PluginManager: IPluginManager {
    private val languageDir: File = File(Main.instance.dataFolder, "language")
    private val fileRegistered: MutableMap<JavaPlugin, MutableMap<ILanguage, LanguageManager>> = HashMap()

    override fun registerPlugin(plugin: JavaPlugin) {
        fileRegistered[plugin] = HashMap()
    }

    override fun registerFile(plugin: JavaPlugin, input: InputStream, lang: ILanguage) {
        if(!fileRegistered.containsKey(plugin))
            throw PluginNotRegisteredException()

        val d = File(languageDir, plugin.name)
        val f = File(d, "${lang.toIETFCode()}.json")

        if(!f.exists()) {
            d.mkdirs()

            f.createNewFile()
            val output = FileOutputStream(f)
            ByteStreams.copy(input, output)
        }

        val lm = LanguageManager(lang)
        Json.decodeFromString(EntryListSerializer, input.bufferedReader().use { it.readText() }).forEach {
            lm.registerEntry(it)
        }

        fileRegistered[plugin]!![lang] = lm
    }
}
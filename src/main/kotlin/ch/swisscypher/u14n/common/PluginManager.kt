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

package ch.swisscypher.u14n.common

import ch.swisscypher.u14n.api.common.lang.EntryListSerializer
import ch.swisscypher.u14n.api.common.lang.ILanguageManager
import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.bungee.Main
import ch.swisscypher.u14n.common.exception.PluginNotRegisteredException
import com.google.common.io.ByteStreams
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.*
import kotlin.collections.HashMap

object PluginManager {
    private lateinit var languageDir: File
    private val fileRegistered: MutableMap<String, MutableMap<ILanguage, ILanguageManager>> = HashMap()
    private val defaultLanguages: MutableMap<String, ILanguage> = HashMap()

    fun init(languageDir: File) {
        this.languageDir = languageDir
    }

    fun registerPlugin(pluginName: String, defaultLanguage: ILanguage) {
        fileRegistered[pluginName] = HashMap()
        defaultLanguages[pluginName] = defaultLanguage
    }

    fun registerFile(pluginName: String, input: InputStream, lang: ILanguage) {
        if(!fileRegistered.containsKey(pluginName))
            throw PluginNotRegisteredException()

        val d = File(languageDir, pluginName)
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

        fileRegistered[pluginName]!![lang] = lm
    }

    fun getLangManager(pluginName: String, lang: ILanguage): Optional<ILanguageManager> {
        if(!fileRegistered.containsKey(pluginName))
            return Optional.empty()

        return Optional.ofNullable(fileRegistered[pluginName]!![lang])
    }

    fun getDefaultLanguage(pluginName: String): Optional<ILanguage> {
        return Optional.ofNullable(defaultLanguages[pluginName])
    }

    fun getSupportedLanguages(pluginName: String): Set<ILanguage> {
        if(!fileRegistered.containsKey(pluginName))
            return setOf()

        return fileRegistered[pluginName]!!.keys
    }
}
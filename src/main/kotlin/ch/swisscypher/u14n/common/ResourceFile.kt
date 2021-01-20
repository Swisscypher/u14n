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

import com.google.common.io.ByteStreams
import java.io.File
import java.io.FileOutputStream

object ResourceFile {
    lateinit var pluginDir: File
    private val configDir: File by lazy { File(pluginDir, "config") }
    val languages: File  by lazy {  File(configDir, "languages.json") }
    val config: File  by lazy {  File(configDir, "config.json") }

    fun init(pluginDir: File) {
        this.pluginDir = pluginDir

        createOrGetFile(languages, "/config/languages.json")
        createOrGetFile(config, "/config/config.json")
    }

    private fun createOrGetFile(file: File, resourcePath: String) {
        if(file.exists())
            return

        if(!File(file.parent).exists())
            File(file.parent).mkdirs()

        file.createNewFile()
        val input = javaClass.getResourceAsStream(resourcePath)
        val output = FileOutputStream(file)
        ByteStreams.copy(input, output)
    }
}
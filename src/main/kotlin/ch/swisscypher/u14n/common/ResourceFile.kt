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
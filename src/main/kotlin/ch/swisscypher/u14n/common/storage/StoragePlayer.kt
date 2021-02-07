package ch.swisscypher.u14n.common.storage

import ch.swisscypher.u14n.api.common.IPlayer
import ch.swisscypher.u14n.api.common.storage.IStoragePlayer
import ch.swisscypher.u14n.common.player.U14nPlayer
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileWriter
import java.util.*

object StoragePlayer: IStoragePlayer {

    lateinit var playerDir: File

    fun init(playerDir: File) {
        this.playerDir = playerDir

        if(!playerDir.exists())
            playerDir.mkdirs()
    }

    override fun getPlayer(uuid: UUID): Optional<IPlayer> {
        val file = File(playerDir, "$uuid.json")

        if(!file.exists())
            return Optional.empty()

        val input = file.inputStream()
        return Optional.ofNullable(Json.decodeFromString(U14nPlayer.serializer(), input.bufferedReader().use { it.readText() }))
    }

    override fun savePlayer(player: IPlayer) {
        val encodeToString = Json.encodeToString(U14nPlayer.serializer(), player as U14nPlayer)
        val file = File(playerDir, "${player.uniqueId}.json")

        if(!file.exists())
            file.createNewFile()

        val writer = FileWriter(file)
        writer.write(encodeToString)
        writer.flush()
    }
}
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
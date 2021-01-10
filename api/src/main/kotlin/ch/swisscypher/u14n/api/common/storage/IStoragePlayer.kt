package ch.swisscypher.u14n.api.common.storage

import ch.swisscypher.u14n.api.common.IPlayer
import java.util.*

interface IStoragePlayer {
    fun getPlayer(uuid: UUID): Optional<IPlayer>

    fun savePlayer(player: IPlayer)
}
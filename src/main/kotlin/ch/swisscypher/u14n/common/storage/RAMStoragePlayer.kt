package ch.swisscypher.u14n.common.storage

import ch.swisscypher.u14n.api.common.IPlayer
import ch.swisscypher.u14n.api.common.storage.IStoragePlayer
import java.util.*
import kotlin.collections.HashMap

class RAMStoragePlayer: IStoragePlayer {

    private val players: HashMap<UUID, IPlayer> = HashMap()

    override fun getPlayer(uuid: UUID): Optional<IPlayer> {
        if(!players.containsKey(uuid))
            return Optional.empty()

        return Optional.ofNullable(players[uuid])
    }

    override fun savePlayer(player: IPlayer) {
        if(players.containsKey(player.uniqueId))
            players.remove(player.uniqueId)

        players[player.uniqueId] = player
    }
}
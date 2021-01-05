package ch.swisscypher.u14n.api.spigot.printable

import ch.swisscypher.u14n.api.common.IPrintable
import org.bukkit.entity.Player

class PrintablePlayer(override val name: String, override val value: Player) : IPrintable<Player> {
    override fun format(): String = value.name
}
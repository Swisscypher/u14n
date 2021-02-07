package ch.swisscypher.u14n.common.player

import ch.swisscypher.u14n.api.common.IPlayer
import ch.swisscypher.u14n.api.common.formatter.printable.IPrintable
import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.common.Formatter
import java.util.*

data class U14nPlayer(override val uniqueId: UUID, override var language: ILanguage) : IPlayer {
    override fun getString(key: String, vararg args: IPrintable<*>): String {
        // TODO: Return the true value

        return Formatter.format(language, key, *args)
    }
}
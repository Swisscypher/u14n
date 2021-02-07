package ch.swisscypher.u14n.common.player

import ch.swisscypher.u14n.api.common.IPlayer
import ch.swisscypher.u14n.api.common.formatter.printable.IPrintable
import ch.swisscypher.u14n.api.common.lang.ILanguage
import ch.swisscypher.u14n.api.common.lang.ILanguageManager
import ch.swisscypher.u14n.common.Formatter
import kotlinx.serialization.Serializable

@Serializable
data class U14nPlayer(override val uniqueId: String, override var language: ILanguage) : IPlayer {
    override fun getString(key: String, languageManager: ILanguageManager, vararg args: IPrintable<*>): String {
        return Formatter.format(language, "{", "}", languageManager.getEntry(key), *args)
    }
}
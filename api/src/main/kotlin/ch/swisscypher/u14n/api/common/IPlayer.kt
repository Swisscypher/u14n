package ch.swisscypher.u14n.api.common

import java.util.*

interface IPlayer {
    val uniqueId: UUID
    var language: ILanguage

    fun sendMessage(key: String, vararg args: IPrintable<*>)
}
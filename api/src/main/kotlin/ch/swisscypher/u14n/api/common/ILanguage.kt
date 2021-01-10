package ch.swisscypher.u14n.api.common

import java.util.*

interface ILanguage {
    val language: String
    val country: String
    val parent: Optional<ILanguage>
    val locale: Locale

    fun toIETFCode(): String
}
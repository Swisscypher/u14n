package ch.swisscypher.u14n.common.lang

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Country(val countryCode: String, val languages: List<String>, val head: String = "DEFAULT"): Comparable<Country> {
    @Contextual
    private val localeCountry = Locale("", countryCode)

    fun getDisplayName(locale: Locale): String {
        return localeCountry.getDisplayCountry(locale)
    }

    override fun compareTo(other: Country): Int {
        return countryCode.compareTo(other.countryCode)
    }
}
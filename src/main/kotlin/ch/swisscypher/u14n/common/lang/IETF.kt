package ch.swisscypher.u14n.common.lang

import java.util.*

// Languages that a plugin can provide
val languages: Set<Locale> by lazy {
    Continent.continents.flatMap { it.countries }
        .flatMap { it.languages }
        .map { Locale.forLanguageTag(it) }
        .flatMap {
            listOf(it, getParent(it)) }
        .toSet()
}

fun getParent(l: Locale) = Locale(l.language)
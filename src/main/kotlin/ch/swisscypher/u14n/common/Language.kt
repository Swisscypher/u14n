package ch.swisscypher.u14n.common

import ch.swisscypher.u14n.api.common.ILanguage
import java.util.*

class Language(
    override val locale: Locale
) : ILanguage {
    override val language: String
        get() = locale.language
    override val country: String
        get() = locale.country
    override val parent: Optional<ILanguage>
        get() = if(locale.country.isNotEmpty()) Optional.of(Language(Locale.forLanguageTag(language))) else Optional.empty()

    override fun toIETFCode(): String {
        return locale.toLanguageTag()
    }
}
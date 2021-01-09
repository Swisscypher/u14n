package ch.swisscypher.u14n.api.common.printable

import ch.swisscypher.u14n.api.common.ILanguage
import ch.swisscypher.u14n.api.common.IPrintable

class PrintableString(override val name: String, override val value: String) : IPrintable<String> {
    override fun format(language: ILanguage): String = value
}
package ch.swisscypher.u14n.common

import ch.swisscypher.u14n.api.common.IFormatter
import ch.swisscypher.u14n.api.common.ILanguage
import ch.swisscypher.u14n.api.common.IPrintable

object Formatter: IFormatter {
    val prefix = "{"
    val suffix = "}"

    override fun format(language: ILanguage, message: String, vararg printables: IPrintable<*>): String {
        return printables.fold(message, {
            acc, iPrintable -> acc.replace(prefix + iPrintable.name + suffix, iPrintable.format(language))
        })
    }
}
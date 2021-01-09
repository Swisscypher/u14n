package ch.swisscypher.u14n.api.common.printable

import ch.swisscypher.u14n.api.common.ILanguage
import ch.swisscypher.u14n.api.common.IPrintable
import java.text.DateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class PrintableShortDate(override val name: String, override val value: Date) : IPrintable<Date> {
    override fun format(language: ILanguage): String
            = DateFormat.getDateInstance(DateFormat.SHORT, language.locale).format(value)
}

class PrintableLongDate(override val name: String, override val value: Date) : IPrintable<Date> {
    override fun format(language: ILanguage): String
            = DateFormat.getDateInstance(DateFormat.LONG, language.locale).format(value)
}

class PrintableLongDateTime(override val name: String, override val value: Date) : IPrintable<Date> {
    override fun format(language: ILanguage): String = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, language.locale).format(value)
}

class PrintableShortDateTime(override val name: String, override val value: Date) : IPrintable<Date> {
    override fun format(language: ILanguage): String = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, language.locale).format(value)
}
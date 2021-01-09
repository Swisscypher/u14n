package ch.swisscypher.u14n.api.common.printable

import ch.swisscypher.u14n.api.common.ILanguage
import ch.swisscypher.u14n.api.common.IPrintable

class PrintableDouble(override val name: String, override val value: Double, private val precision: Int = 2) : IPrintable<Double> {
    override fun format(language: ILanguage): String = String.format("%.${precision}f", value)
}

class PrintableShort(override val name: String, override val value: Short) : IPrintable<Short> {
    override fun format(language: ILanguage): String = value.toString()
}

class PrintableFloat(override val name: String, override val value: Float, private val precision: Int = 2) : IPrintable<Float> {
    override fun format(language: ILanguage): String = String.format("%.${precision}f", value)
}

class PrintableLong(override val name: String, override val value: Long) : IPrintable<Long> {
    override fun format(language: ILanguage): String = value.toString()
}

class PrintableInt(override val name: String, override val value: Int) : IPrintable<Int> {
    override fun format(language: ILanguage): String = value.toString()
}

class PrintableByte(override val name: String, override val value: Byte) : IPrintable<Byte> {
    override fun format(language: ILanguage): String = value.toString()
}

class PrintableBoolean(override val name: String, override val value: Boolean) : IPrintable<Boolean> {
    override fun format(language: ILanguage): String = value.toString()
}

class PrintableChar(override val name: String, override val value: Char) : IPrintable<Char> {
    override fun format(language: ILanguage): String = value.toString()
}
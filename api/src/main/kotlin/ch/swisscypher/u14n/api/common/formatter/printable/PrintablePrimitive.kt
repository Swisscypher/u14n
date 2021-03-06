/*
 * Copyright 2021 Comore, Zayceur
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.swisscypher.u14n.api.common.formatter.printable

import ch.swisscypher.u14n.api.common.lang.ILanguage


/**
 * Float formatter with precision
 */
class PrintableFloat(override val name: String, override val value: Float, private val precision: Int = 2) :
    IPrintable<Float> {
    override fun format(language: ILanguage): String = String.format("%.${precision}f", value)
}

/**
 * Double formatter with precision
 */
class PrintableDouble(override val name: String, override val value: Double, private val precision: Int = 2) :
    IPrintable<Double> {
    override fun format(language: ILanguage): String = String.format("%.${precision}f", value)
}

/**
 * Byte formatter
 */
class PrintableByte(override val name: String, override val value: Byte) : IPrintable<Byte> {
    override fun format(language: ILanguage): String = value.toString()
}

/**
 * Short formatter
 */
class PrintableShort(override val name: String, override val value: Short) : IPrintable<Short> {
    override fun format(language: ILanguage): String = value.toString()
}

/**
 * Int formatter
 */
class PrintableInt(override val name: String, override val value: Int) : IPrintable<Int> {
    override fun format(language: ILanguage): String = value.toString()
}

/**
 * Long formatter
 */
class PrintableLong(override val name: String, override val value: Long) : IPrintable<Long> {
    override fun format(language: ILanguage): String = value.toString()
}

/**
 * Boolean formatter
 */
class PrintableBoolean(override val name: String, override val value: Boolean) : IPrintable<Boolean> {
    override fun format(language: ILanguage): String = value.toString()
}

/**
 * Char formatter
 */
class PrintableChar(override val name: String, override val value: Char) : IPrintable<Char> {
    override fun format(language: ILanguage): String = value.toString()
}
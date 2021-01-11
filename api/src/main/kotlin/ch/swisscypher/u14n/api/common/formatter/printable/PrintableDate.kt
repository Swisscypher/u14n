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
import java.text.DateFormat
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
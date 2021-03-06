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

package ch.swisscypher.u14n.api.common.formatter

import ch.swisscypher.u14n.api.common.formatter.printable.IPrintable
import ch.swisscypher.u14n.api.common.lang.ILanguage

/**
 * Fromat a message using {@link IPrintable} and the given language
 */
interface IFormatter {
    /**
     * @param language The language the message is
     * @param prefix The prefix of the tokens
     * @param suffix The suffix of the tokens
     * @param message The raw message with tokens
     * @param printables The custom values we need to change inside the message
     * @return The string formatter using all the printables
     */
    fun format(language: ILanguage, prefix: String = "{", suffix: String = "}", message: String, vararg printables: IPrintable<*>): String
}
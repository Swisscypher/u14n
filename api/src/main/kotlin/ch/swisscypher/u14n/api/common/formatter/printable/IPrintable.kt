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
 * Represent a printable value inside a string
 */
interface IPrintable<T> {
    val name: String
    val value: T

    /**
     * Format the value with a given language
     * @param language The language
     * @return The string formatted based on the language
     */
    fun format(language: ILanguage): String
}
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

package ch.swisscypher.u14n.api.common.location

import ch.swisscypher.u14n.api.bungee.IPluginManager
import ch.swisscypher.u14n.api.common.ICountry
import java.net.InetAddress
import java.util.*

/**
 * A class representing a service providing the country of a given IP
 */
interface ILocationFinder {
    /**
     * @param address The IP address we want to know the country
     * @return The IP address country
     */
    fun findLocale(address: InetAddress): Optional<ICountry>

    companion object {
        val locationFinder = ServiceLoader.load(ILocationFinder::class.java).findFirst().get()
    }
}
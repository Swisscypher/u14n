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

package ch.swisscypher.u14n.common.location

import ch.swisscypher.u14n.api.common.ICountry
import ch.swisscypher.u14n.api.common.location.ILocationFinder
import ch.swisscypher.u14n.common.lang.Country
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.InetAddress
import java.net.URL
import java.util.*
import java.util.stream.Collectors

@Serializable
data class IPAPIResponse(
    val ip: String,
    val country_code: String
)

class IPAPILocationFinder: ILocationFinder {
    val urlPath = "https://ipapi.co/%s/json"

    override fun findLocale(address: InetAddress): Optional<ICountry> {
        val url = URL(urlPath.format(address.hostAddress))

        val connection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.connect()

        if(connection.responseCode != 200)
            return Optional.empty()

        val content = BufferedReader(InputStreamReader(connection.inputStream)).lines().collect(Collectors.joining())
        val element = Json {ignoreUnknownKeys = true}.decodeFromString(IPAPIResponse.serializer(), content)

        return Optional.ofNullable(Country.countries
            .find { it.countryCode == element.country_code })
    }
}
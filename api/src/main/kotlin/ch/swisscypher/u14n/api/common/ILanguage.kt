package ch.swisscypher.u14n.api.common

interface ILanguage {
    val language: String
    val country: String
    val parent: ILanguage

    fun toIETFCode(): String
}
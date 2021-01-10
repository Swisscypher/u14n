package ch.swisscypher.u14n.api.common

interface IFormatter {
    fun format(language: ILanguage, message: String, vararg printables: IPrintable<*>): String
}
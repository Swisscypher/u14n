package ch.swisscypher.u14n.api.common

interface IPrintable<T> {
    val name: String
    val value: T

    fun format(): String
}
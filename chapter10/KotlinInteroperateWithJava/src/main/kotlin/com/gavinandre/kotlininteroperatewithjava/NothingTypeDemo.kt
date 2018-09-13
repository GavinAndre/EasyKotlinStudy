package com.gavinandre.kotlininteroperatewithjava

class NothingTypeDemo {

    fun emptyList(): List<Nothing> = listOf()

    fun emptyList2(): List<Nothing?> = listOf()

}
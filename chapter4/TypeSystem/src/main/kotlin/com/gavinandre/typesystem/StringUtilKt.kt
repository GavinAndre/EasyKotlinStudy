package com.gavinandre.typesystem

class StringUtilKt {

    fun getLength1(str: String): Int {
        return str.length
    }

    fun getLength2(str: String?): Int? {
        return str?.length
    }

    fun getLength3(str: String?): Int? {
        return str!!.length
    }
}
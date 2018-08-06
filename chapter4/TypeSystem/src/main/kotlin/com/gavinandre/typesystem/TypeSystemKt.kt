package com.gavinandre.typesystem

fun strLen(ani: Any): Int {
    if (ani is String) {
        return ani.length
    } else if (ani is Number) {
        return ani.toString().length
    } else if (ani is Char) {
        return 1
    } else if (ani is Boolean) {
        return 1
    }

    println("Not A String")
    return -1
}

open class Foo
class Goo : Foo()
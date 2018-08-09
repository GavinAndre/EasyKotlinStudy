package com.gavinandre.generics

/**
 * 泛型类
 */
class Box<T>(val value: T)

/**
 * 泛型函数
 */
fun <T> singletonList(item: T): List<T> {
    return listOf(item)
}

/**
 * 泛型扩展函数
 */
fun <T> T.basicToString(): String {
    return this.toString()
}

/**
 * 泛型扩展属性
 */
val <T> T.size: Int get() = this.toString().length

package com.gavinandre.kotlin

/**
 * 非空引用不能直接赋值为null
 */
fun nullSafety1() {
    var a = "abc"
    //    a = null
    //    error: null can not be a value of a non-null type String

    var one = 1
    //    one = null
    //    error: null can not be a value of a non-null type Int

    var arrayInts = intArrayOf(1, 2, 3)
    //    arrayInts = null
    //    error: null can not be a value of a non-null type intArray
}

/**
 * 在变量的类型后面加个问号?声明一个变量为可空的
 */
fun nullSafety2() {
    var a: String? = "abc"
    a = null
    println(a)
    //    println(a.length)
    println(a?.length)
    //    println(a!!.length)
    //    kotlin.KotlinNullPointerException
    var one: Int? = 1
    one = null
    println(one)
    println(one?.dec())
    //    println(one!!.dec())
    var arrayInts: IntArray? = intArrayOf(1, 2, 3)
    arrayInts = null
    println(arrayInts)
    println(arrayInts?.size)
    //    println(arrayInts!!.size)
}

fun nullSafety3() {
    val listWithNulls: List<String?> = listOf("A", "B", null)
    println(listWithNulls)

    listWithNulls.forEach {
        //表示it不为null的条件下，才会去执行let函数体
        it?.let { println(it) }
    }
}
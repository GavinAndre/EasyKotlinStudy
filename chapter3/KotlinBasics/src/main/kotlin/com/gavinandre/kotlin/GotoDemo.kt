package com.gavinandre.kotlin

fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int): Int = a + b

fun max1(a: Int, b: Int): Int {
    if (a > b) return a else return b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b

fun breakDemo1() {
    println("---------------  breakDemo_1 ---------------")
    //数字区间循环
    for (outer in 1..5) {
        println("outer= $outer")
        for (inner in 1..10) {
            println("inner= $inner")
            if (inner % 2 == 0) {
                //跳出最近外层的循环
                break
            }
        }
    } // break to here
}

fun breakDemo2() {
    println("---------------  breakDemo_2 ---------------")
    //数字区间循环
    outer@ for (outer in 1..5) {
        println("outer= $outer")
        for (inner in 1..10) {
            println("inner= $inner")
            if (inner % 2 == 0) {
                //跳出标签处的循环
                break@outer
            }
        }
    } // break to here
}

fun breakDemo3() {
    println("---------------  breakDemo_3 ---------------")
    //数字区间循环
    for (outer in 1..5) {
        println("outer= $outer")
        inner@ for (inner in 1..10) {
            println("inner= $inner")
            if (inner % 2 == 0) {
                //使用标签提高代码可读性
                break@inner
            }
        }
    } // break to here
}

fun continueDemo() {
    for (i in 1..10) {
        if (i % 2 == 0) {
            continue
        }
        println(i)
    }
}

fun returnDemo1() {
    println("START " + ::returnDemo1.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    intArray.forEach {
        //在Lambda表达式中遇到return，则直接返回最近的外层函数
        if (it == 3) return
        println(it)
    }
    println("END " + ::returnDemo1.name)
}

fun returnDemo2() {
    println("START " + ::returnDemo2.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    intArray.forEach(fun(a: Int) {
        //匿名函数内部的 return 语句只从该匿名函数自身返回(循环继续执行)类似continue
        if (a == 3) return
        println(a)
    })
    println("END " + ::returnDemo2.name)
}

fun returnDemo3() {
    println("START " + ::returnDemo3.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    //在Lambda表达式指令执行入口标记标签here@,通过return@here跳转到Lambda执行入口
    intArray.forEach here@{
        if (it == 3) return@here
        println(it)
    }
    println("END " + ::returnDemo3.name)
}

fun returnDemo4() {
    println("START " + ::returnDemo4.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    intArray.forEach {
        //隐式标签@forEach
        if (it == 3) return@forEach
        println(it)
    }
    println("END " + ::returnDemo4.name)
}
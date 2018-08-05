package com.gavinandre.kotlin

class ForDemo {
    fun for1() {
        val intArray = arrayOf(1, 2, 3)
        val strArray = arrayOf("11", "22", "33")
        //获取value
        for (value in intArray) {
            println("int: $value")
        }
        //获取index
        for (index in intArray.indices) {
            println("indices: ${intArray[index]}")
        }
        //同时获取index和value
        for ((index, value) in intArray.withIndex()) {
            println("withIndex: $index value is $value")
        }
        for (str in strArray) {
            println("String: $str")
        }
        //lambda初始化array
        val intArray1 = Array(5, { i -> i + 1 })
        intArray1.forEach {
            println("foreach $it")
        }
    }
}
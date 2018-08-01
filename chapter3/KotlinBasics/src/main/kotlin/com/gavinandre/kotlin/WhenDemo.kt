package com.gavinandre.kotlin

import java.lang.Integer.parseInt

class WhenDemo {
    fun when1(obj: Any) {
        when (obj) {
        //自带break
            1 -> println("第一项")
            "hello" -> println("这个是字符串hello")
            is Long -> println("这是一个Long类型数据")
            !is Long -> println("这不是String类型的数据")
            else -> println("else类似于Java中的default")
        }
    }

    fun when2(x: Int) {
        val s = "123"
        when (x) {
        //多条件检测
            -1, 0 -> println("x == -1 or x == 0")
            1 -> println("x == 1")
            2 -> println("x == 2")
            8 -> println("x == 8")
        //表达式检测
            parseInt(s) -> println("x is 123")
            else -> {
                println("x is neither 1 nor 2")
            }
        }
    }

    fun when3(x: Int) {
        val validNumbers = arrayOf(1, 2, 3)
        when (x) {
        //区间检测
            in 1..10 -> println("x is in the range")
        //集合检测
            in validNumbers -> println("x is valid")
            !in 10..20 -> println("x is outside the range")
            else -> println("none of the above")
        }
    }
}
package com.gavinandre.kotlin

class IfDemo {
    fun max(a: Int, b: Int): Int {
        //无Java中?:三目运算符
        val max = if (a > b) a else b
        return max
    }

    fun max1(a: Int, b: Int): Int {
        //传统用法
        var max1 = a
        if (a < b) max1 = b
        return max1
    }

    fun max2(a: Int, b: Int): Int {
        //with else
        var max2: Int
        if (a > b) {
            max2 = a
        } else {
            max2 = b
        }
        return max2
    }

    fun max3(a: Int, b: Int): Int {
        val max = if (a > b) {
            println("Max is a")
            a
        } else {
            println("Max is b")
            b
        }
        return max
    }
}


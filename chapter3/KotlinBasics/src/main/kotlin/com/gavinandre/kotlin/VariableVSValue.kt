package com.gavinandre.kotlin

import java.util.*

class VariableVSValue {
    fun declareVar() {
        //        var 是可写的，在它生命周期中可以被多次赋值
        var a = 1
        a = 2
        println(a)
        println(a::class)
        println(a::class.java)

        var x = 5 //自动推断出Int类型
        x += 1

        println("x=$x")
    }

    fun declareVal() {
        //        val,仅能一次赋值，后面就不能被重新赋值
        //        Kotlin中首选使用val,益处:可预测的行为和线程安全
        val b = "a"
        //        b = "b" //编译器报错 Val cannot be reassigned
        println(b)
        println(b::class)
        println(b::class.java)

        val c: Int = 1 //立即赋值
        val d = 2 //自动推断出Int类型
        val e: Int //如果没有初始值类型不能省略
        e = 3 //明确赋值
        println("c= $c ,d= $d ,e=$e")
    }

    fun typeInference() {
        val str = "abc"
        println(str)
        println(str is String)
        println(str::class)
        println(str::class.java)

        val d = Date()
        println(d)
        println(d is Date)
        println(d::class)
        println(d::class.java)

        val bool = true
        println(bool)
        println(bool is Boolean)
        println(bool::class)
        println(bool::class.java)

        val array = arrayOf(1, 2, 3)
        println(array)
        println(array is Array)
        println(array::class)
        println(array::class.java)
    }

    fun Int2Long() {
        val x: Int = 10
        //        val y: Long = x //Type mismatch
        val y: Long = x.toLong() //Type mismatch
    }

    fun getLength(obj: Any): Int? {
        var result = 0
        //is相当于Java中instanceof
        if (obj is String) {
            // obj 在该条件分支内自动转换成 String
            println(obj::class)
            result = obj.length
            println(result)
        }
        // 在离开类型检测分支后, obj任然是 Any 类型
        println(obj::class)
        return result
    }


}
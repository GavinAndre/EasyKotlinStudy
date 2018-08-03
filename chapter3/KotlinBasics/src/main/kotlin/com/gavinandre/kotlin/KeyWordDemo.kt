package com.gavinandre.kotlin

class ThisDemo {

    val thisis = "THIS IS"

    fun whatIsThis(): ThisDemo {
        //引用变量
        println(this.thisis)
        //引用成员函数
        this.howIsThis()
        //返回此类的引用
        return this
    }

    fun howIsThis() {
        println("HOW IS THIS ?")
    }
}

class Outer {

    val oh = "oh!"

    inner class Inner {

        fun m() {
            val outer = this@Outer
            val inner = this@Inner
            //没有限定符的this表示最内层的包含它的类作用域
            val pThis = this
            println("outer= $outer")
            println("inner= $inner")
            println("pThis= $pThis")
            println(this@Outer.oh)

            //在扩展函数或者带接收者的函数字面值中， this 表示在点左侧传递的接收者参数
            val fun1 = fun Int.() {
                val d1 = this
                println("d1$d1")
            }

            val fun2 = hello@ fun String.() {
                val d2 = this@hello
                println("d2$d2")
            }

            val fun3 = { s: String ->
                val d3 = this
                println("d3= $d3")
            }

            1.fun1()
            fun1(2)
            "abc".fun2()
            fun2("cba")
            fun3("adc")
        }
    }
}

open class Father {
    open val firstName = "Gavin"
    open val lastName = "Andre"

    fun ff() {
        println("FFF")
    }
}

class Son : Father {

    override var firstName = super.firstName
    override var lastName = "Andrew"

    constructor(firstName: String) {
        this.firstName = firstName
    }

    fun ss() {
        //调用父类方法
        super.ff()
        println("${super.firstName} ${super.lastName} ${this.firstName} ${this.lastName} ")
    }

}
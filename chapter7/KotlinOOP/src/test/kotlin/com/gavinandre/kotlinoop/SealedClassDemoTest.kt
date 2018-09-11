package com.gavinandre.kotlinoop

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SealedClassDemoTest {

    @Test
    fun test() {
        val u = eval(Unit())
        val a = eval(Const(1.1))
        val b = eval(Sum(Const(1.0), Const(9.0)))
        val c = eval(Multiply(Const(10.0), Const(10.0)))
        println(u)
        println(a)
        println(b)
        println(c)
    }
}
package com.gavinandre.kotlinoop

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ClassAndInstancesDemoTest {

    @Test
    fun test() {
        val w1 = World1()
        println(w1.yin)
        println(w1.yang)

        val w2 = World2()
        println(w2.plus())

//        val p = Person("gavinandre", "28")
    }
}
package com.gavinandre.generics

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GenericTypeTest {

    @Test
    fun testGenericType() {
        val b1: Box<Int> = Box<Int>(1)
        val b2: Box<Int> = Box(1)
        val b3 = Box(1)

        val l = singletonList<Int>(1)
        println(l)

        println(1f.basicToString())
        println(1f.size)
    }
}
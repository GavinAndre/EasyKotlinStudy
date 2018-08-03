package com.gavinandre.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class OperatorDemoTest {
    @Test
    fun testPointUnaryMinus() {
        val p = Point(1, 1)
        val np = -p
        println(np)
    }

    @Test
    fun testCounterIndexPlus() {
        val c = Counter(1)
        val cPlus = c + 10
        println(cPlus)
    }
}
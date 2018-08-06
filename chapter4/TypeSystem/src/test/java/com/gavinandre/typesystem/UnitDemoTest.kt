package com.gavinandre.typesystem

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UnitDemoTest {
    @Test
    fun testUnitDemo() {
        val ur1 = unitReturn1()
        println(ur1)
        val ur2 = unitReturn2()
        println(ur2)
        val ur3 = unitReturn3()
        println(ur3)
    }

    fun unitReturn1() {

    }

    fun unitReturn2() {
        return Unit
    }

    fun unitReturn3(): Unit {
    }
}
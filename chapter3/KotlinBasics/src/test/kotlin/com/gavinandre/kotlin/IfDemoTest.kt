package com.gavinandre.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class IfDemoTest {

    val ifDemo = IfDemo()

    @Test
    fun testIfDemo() {
        println("testIfDemo: ${ifDemo.max(1, 2)}")
    }

    @Test
    fun testIfDemo1() {
        println("testIfDemo1: ${ifDemo.max1(1, 2)}")
    }

    @Test
    fun testIfDemo2() {
        println("testIfDemo2: ${ifDemo.max2(1, 2)}")
    }

    @Test
    fun testIfDemo3() {
        println("testIfDemo3: ${ifDemo.max3(1, 2)}")
    }
}

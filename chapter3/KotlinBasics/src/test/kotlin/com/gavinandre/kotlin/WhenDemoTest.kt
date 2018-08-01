package com.gavinandre.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WhenDemoTest {

    val whenDemo = WhenDemo()

    @Test
    fun testWhenDemo() {
        whenDemo.when1(1)
        whenDemo.when1("hello")
        whenDemo.when1(100L)
        whenDemo.when1(true)
        whenDemo.when1(Any())

        whenDemo.when2(1)
        whenDemo.when2(123)

        whenDemo.when3(1)
    }

}
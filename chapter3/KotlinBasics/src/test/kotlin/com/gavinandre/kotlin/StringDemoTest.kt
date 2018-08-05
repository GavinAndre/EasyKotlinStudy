package com.gavinandre.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StringDemoTest {
    val stringDemo = StringDemo()

    @Test
    fun testStringDemo() {
        val rawString1 = stringDemo.rawString1()
        println("raw String: \n$rawString1")
        val rawString2 = stringDemo.rawString2()
        println("raw String: \n$rawString2")
        println("template String: \n${stringDemo.templateString(rawString1)}")
    }

}
package com.gavinandre.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StringDemoTest {
    val stringDemo = StringDemo()

    @Test
    fun testStringDemo() {
        val rawString = stringDemo.rawString()
        println("raw String: $rawString")
        println("template String: ${stringDemo.templateString(rawString)}")
    }

}
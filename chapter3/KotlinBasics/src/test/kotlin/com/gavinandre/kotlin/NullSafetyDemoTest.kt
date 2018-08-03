package com.gavinandre.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NullSafetyDemoTest {

    @Test
    fun testExtensions() {
        nullSafety1()
        nullSafety2()
        nullSafety3()
    }

}
package com.gavinandre.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class KeyWordDemoTest {

    @Test
    fun testThisDemo() {
        val thisDemo = ThisDemo()
        println(thisDemo.whatIsThis())
    }

    @Test
    fun testThisKeyWord() {
        val outer = Outer()
        outer.Inner().m()
    }

    @Test
    fun testSuperKeyWord() {
        val son = Son("Gawain")
        son.ss()
    }

}
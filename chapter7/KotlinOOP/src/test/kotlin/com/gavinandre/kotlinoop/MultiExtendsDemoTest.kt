package com.gavinandre.kotlinoop

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MultiExtendsDemoTest {

    @Test
    fun test() {
        val d = Dog()
        d.doEat()
        d.doRun()

        val e = Eagle()
        e.doEat()
        e.doFly()

        val a = Archaeopteryx()
        a.doEat()
        a.doRun()
        a.doFly()
    }
}
package com.gavinandre.kotlincoroutines

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LightWeightCoroutinesDemoTest {

    @Test
    fun test() {
        val lwc = LightWeightCoroutinesDemo()
//        lwc.testThread()
//        lwc.testLightWeightCoroutine()
        lwc.testDaemon1()
//        lwc.testDaemon2()

    }
}
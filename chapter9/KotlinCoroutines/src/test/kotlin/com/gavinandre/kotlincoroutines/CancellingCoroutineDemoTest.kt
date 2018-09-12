package com.gavinandre.kotlincoroutines

import kotlinx.coroutines.experimental.CancellationException
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CancellingCoroutineDemoTest {

    @Test
    fun test() {
        val cc = CancellingCoroutineDemo()
//        cc.testCancellation()
//        cc.testCooperativeCancellation1()
//        cc.testCooperativeCancellation2()
//        cc.testCooperativeCancellation3()
//        cc.finallyCancelDemo()
//        cc.testNonCancellable()
        try {
            cc.testTimeouts()
        } catch (e: CancellationException) {
            println("I am timed out")
        }
    }
}
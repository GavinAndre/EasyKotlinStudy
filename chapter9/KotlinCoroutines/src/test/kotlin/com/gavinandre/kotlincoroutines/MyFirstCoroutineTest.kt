package com.gavinandre.kotlincoroutines

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MyFirstCoroutineTest {

    @Test
    fun test() {
//        MyFirstCoroutine.firstCoroutineDemo0()
//        MyFirstCoroutine.callSuspendFun()
        MyFirstCoroutine.threadCoroutineDemo()
    }
}
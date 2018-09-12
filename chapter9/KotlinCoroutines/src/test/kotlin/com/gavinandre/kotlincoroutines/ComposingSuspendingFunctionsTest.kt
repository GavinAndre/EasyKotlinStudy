package com.gavinandre.kotlincoroutines

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ComposingSuspendingFunctionsTest {

    @Test
    fun test() {
        val csf = ComposingSuspendingFunctions()
//        csf.testSequential()
//        csf.testAsync()
//        csf.testDispatchersAndThreads()
//        csf.testRunBlockingWithSpecifiedContext()
        csf.testChildrenCoroutine()
    }
}
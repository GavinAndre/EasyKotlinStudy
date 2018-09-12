package com.gavinandre.kotlinfop

import com.gavinanere.kotlinfop.FPApi
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FPApiTest {

    @Test
    fun test() {
//        println(membersOf<StringBuilder>().joinToString("\n"))

        FPApi().closureDemo()
        //进程保活,使子线程可以执行完
        Thread.sleep(21000)
    }
}
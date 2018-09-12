package com.gavinandre.kotlincoroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RunBlockTest {

    /**
     * runBlocking函数不是用来当做普通协程函数使用的，
     * 它的设计主要是用来桥接普通阻塞代码和挂起风格的（suspending style）的非阻塞代码的,
     * 例如用在 main 函数中，或者用于测试用例代码中
     */
    @Test
    fun test() = runBlocking {
        // 这样我们就可以在这里调用任何suspend fun了
        launch(CommonPool) {
            delay(3000L)
            println("Hello,")
        }
        println("World!")
        delay(5000L)
    }
}
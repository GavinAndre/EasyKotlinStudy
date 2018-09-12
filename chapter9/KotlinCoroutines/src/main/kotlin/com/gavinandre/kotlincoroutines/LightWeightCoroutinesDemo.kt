package com.gavinandre.kotlincoroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

class LightWeightCoroutinesDemo {

    fun testThread() {
        val jobs = List(100_000) {
            Thread {
                Thread.sleep(1000L)
                print(".")
            }
        }
        jobs.forEach { it.start() }
        jobs.forEach { it.join() }
    }

    fun testLightWeightCoroutine() = runBlocking {
        val jobs = List(100_000) {
            // create a lot of coroutines and list their jobs
            launch {
                delay(1000L)
                print(".")
            }
        }
        jobs.forEach { it.join() }
    }

    fun testDaemon1() = runBlocking {
        launch(CommonPool) {
            repeat(100) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(2000L) // just quit after delay
    }

    /**
     * 守护线程，是指在程序运行的时候在后台提供一种通用服务的线程，比如垃圾回收线程就是一个很称职的守护者，
     * 并且这种线程并不属于程序中不可或缺的部分。因此，当所有的非守护线程结束时，程序也就终止了，同时会杀死进程中的所有守护线程
     */
    fun testDaemon2() {
        val t = Thread {
            repeat(100) { i ->
                println("I'm sleeping $i ...")
                Thread.sleep(500L)
            }
        }
        t.isDaemon = true //必须在启动线程前调用,否则会报错：Exception in thread "main" java.lang.IllegalThreadStateException
        t.start()
        Thread.sleep(2000L) //just quit after delay
    }

}
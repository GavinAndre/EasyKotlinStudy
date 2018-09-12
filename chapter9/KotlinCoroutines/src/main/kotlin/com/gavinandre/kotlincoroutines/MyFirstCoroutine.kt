package com.gavinandre.kotlincoroutines

import kotlinx.coroutines.experimental.*
import java.util.concurrent.TimeUnit

object MyFirstCoroutine {

    /**
     * CommonPool是代表共享线程池，它的主要作用是来调度计算密集型任务的协程的执行。
     * 它的实现使用的是java.util.concurrent包下面的API。
     * 它首先尝试创建一个java.util.concurrent.ForkJoinPool（ForkJoinPool是一个可以执行ForkJoinTask的ExcuteService，
     * 它采用了work-stealing模式：所有在池中的线程尝试去执行其他线程创建的子任务，这样很少有线程处于空闲状态，更加高效）；
     * 如果不可用，就使用java.util.concurrent.Executors来创建一个普通的线程池：Executors.newFixedThreadPool
     */
    fun firstCoroutineDemo0() {
        //launch函数它以非阻塞（non-blocking）当前线程的方式，启动一个新的协程后台任务，并返回一个Job类型的对象作为当前协程的引用
        launch(CommonPool, CoroutineStart.DEFAULT) {
            //类似Thread.sleep(),但不阻塞线程,只是挂起
            delay(3000L, TimeUnit.MILLISECONDS)
            println("Hello,")
        }
        println("World!")
        Thread.sleep(5000L)
    }

    /**
     * suspend 挂起函数,只能从协程代码内部调用，普通的非协程的代码不能调用
     */
    suspend fun runCoroutineDemo() {
        withContext(CommonPool) {
            delay(3000L, TimeUnit.MILLISECONDS)
            println("Hello,")
        }
    }

    fun callSuspendFun() {
        launch(CommonPool) { runCoroutineDemo() }
        println("World!")
        Thread.sleep(5000L)
    }

    /**
     * 错误反例：用线程调用协程 error
     */
    fun threadCoroutineDemo() {
        Thread {
            //            delay(3000L, TimeUnit.MILLISECONDS) // error, Suspend functions are only allowed to be called from a coroutine or another suspend function
            println("Hello,")
        }.start()
        println("World!")
        Thread.sleep(5000L)
    }

}
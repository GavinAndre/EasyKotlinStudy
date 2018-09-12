package com.gavinandre.kotlincoroutines

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.coroutineContext
import kotlin.system.measureTimeMillis

class ComposingSuspendingFunctions {

    suspend fun doJob1(): Int {
        println("Doing Job1 ...")
        delay(1000L) //此处模拟工作代码
        println("Job1 Done")
        return 10
    }

    suspend fun doJob2(): Int {
        println("Doing Job2 ...")
        delay(1000L) //此处模拟工作代码
        println("Job2 Done")
        return 20
    }

    /**
     * 协同中的代码默认按顺序执行
     */
    fun testSequential() = runBlocking {
        val time = measureTimeMillis {
            val one = doJob1()
            val two = doJob2()
            println("[testSequential] 最终结果： ${one + two}")
        }
        println("[testSequential] Completed in $time ms")
    }

    /**
     * 使用async来实现异步执行
     * 与launch不同之处:返回一个延迟任务对象Deferred，继承于job,一种轻量级的非阻塞性future, 它表示后面会提供结果
     */
    fun testAsync() = runBlocking {
        val time = measureTimeMillis {
            val one = async(CommonPool) { doJob1() }
            val two = async(CommonPool) { doJob2() }
            //await()等待此延迟任务完成，而不阻塞线程；如果延迟任务完成, 则返回结果值或引发相应的异常
            println("最终结果： ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }

    fun testDispatchersAndThreads() = runBlocking {
        val jobs = arrayListOf<Job>()
        jobs += launch(Unconfined) {
            println("Unconfined: I'm working in thread ${Thread.currentThread()}")
        }
        jobs += launch(coroutineContext) {
            // 父协程的上下文 ： runBlocking coroutine
            println("context: I'm working in thread ${Thread.currentThread()}")
        }
        //launch不传CoroutineContext的话默认运行在CommonPool中
        jobs += launch {
            // 调度指派给 ForkJoinPool.commonPool
            println("default: I'm working in thread ${Thread.currentThread()}")
        }
        jobs += launch(CommonPool) {
            // 调度指派给 ForkJoinPool.commonPool
            println("CommonPool: I'm working in thread ${Thread.currentThread()}")
        }
        jobs += launch(newSingleThreadContext("MyOwnThread")) {
            // 将会在这个协程自己的新线程中执行
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread()}")
        }
        jobs.forEach {
            it.join()
        }
    }

    fun log(msg: String) = println("${Thread.currentThread()} $msg")

    fun testRunBlockingWithSpecifiedContext() = runBlocking {
        log("$coroutineContext")
        log("${coroutineContext[Job]}")
        log("开始")

        //创建新线程context
        val ctx1 = newSingleThreadContext("线程A")
        val ctx2 = newSingleThreadContext("线程B")
        //切换context
        runBlocking(ctx1) {
            log("Started in Context1")
            withContext(ctx2) {
                log("Working in Context2")
            }
            log("Back to Context1")
        }
        log("结束")
    }

    /**
     * 使用协程A的上下文启动另一个协程B时, B将成为A的子协程。当父协程A任务被取消时, B以及它的所有子协程都会被递归地取消
     */
    fun testChildrenCoroutine()= runBlocking<Unit> {
        val request = launch(CommonPool) {
            log("ContextA1: ${coroutineContext}")

            val job1 = launch(CommonPool) {
                println("job1: 独立的协程上下文!")
                delay(1000)
                println("job1: 不会受到request.cancel()的影响")
            }
            // 继承父上下文：request的context
            val job2 = launch(coroutineContext) {
                log("ContextA2: ${coroutineContext}")
                println("job2: 是request coroutine的子协程")
                delay(1000)
                println("job2: 当request.cancel()，job2也会被取消")
            }
            job1.join()
            job2.join()
        }
        delay(500)
        request.cancel()
        delay(1000)
        println("main: Who has survived request cancellation?")
    }

}
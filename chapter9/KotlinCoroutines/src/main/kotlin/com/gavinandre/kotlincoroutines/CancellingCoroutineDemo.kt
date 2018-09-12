package com.gavinandre.kotlincoroutines

import kotlinx.coroutines.experimental.*

class CancellingCoroutineDemo {

    /**
     * 协程执行的取消
     */
    fun testCancellation() = runBlocking {
        val job = launch(CommonPool) {
            repeat(1000) {
                println("I'm sleeping $it ... CurrentThread: ${Thread.currentThread()}")
                delay(500L)
            }
        }
        delay(1300L)
        println("CurrentThread: ${Thread.currentThread()}")
        println("Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")
        val b1 = job.cancel() // cancels the job
        println("job cancel: $b1")
        delay(1300L)
        println("Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")

        val b2 = job.cancel() // cancels the job, job already canceld, return false
        println("job cancel: $b2")

        println("main: Now I can quit.")
    }

    /**
     * 计算代码的协程取消失效
     * 协程正工作在循环计算中，并且不检查协程当前的状态, 那么调用cancel来取消协程将无法停止协程的运行
     */
    fun testCooperativeCancellation1() = runBlocking<Unit> {
        val job = launch(CommonPool) {
            var nextPrintTime = 0L
            var i = 0
            while (i < 20) {
                val currentTime = System.currentTimeMillis()
                if (currentTime >= nextPrintTime) {
                    println("I'm sleeping ${i++} ... CurrentThread: ${Thread.currentThread()}")
                    nextPrintTime = currentTime + 500L
                }
            }
        }
        delay(3000L)
        println("CurrentThread: ${Thread.currentThread()}")
        println("Before cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")

        val b1 = job.cancel() // cancels the job
        println("job cancel1: $b1")
        println("After Cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")

        delay(30000L)

        val b2 = job.cancel() // cancels the job, job already canceld, return false
        println("job cancel2: $b2")

        println("main: Now I can quit.")
    }

    /**
     * 显式检查取消状态isActive
     */
    fun testCooperativeCancellation2() = runBlocking<Unit> {
        val job = launch(CommonPool) {
            var nextPrintTime = 0L
            var i = 0
            while (i < 20) {

                //检查isActive状态
                if (!isActive) {
                    return@launch
                }

                val currentTime = System.currentTimeMillis()
                if (currentTime >= nextPrintTime) {
                    println("I'm sleeping ${i++} ... CurrentThread: ${Thread.currentThread()}")
                    nextPrintTime = currentTime + 500L
                }
            }
        }
        delay(3000L)
        println("CurrentThread: ${Thread.currentThread()}")
        println("Before cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")

        val b1 = job.cancel() // cancels the job
        println("job cancel1: $b1")
        println("After Cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")

        delay(30000L)

        val b2 = job.cancel() // cancels the job, job already canceld, return false
        println("job cancel2: $b2")

        println("main: Now I can quit.")
    }

    /**
     * 循环调用一个挂起函数yield()
     * 通过job的isCompleted状态值来捕获CancellationException完成取消功能
     */
    fun testCooperativeCancellation3() = runBlocking<Unit> {
        val job = launch(CommonPool) {
            var nextPrintTime = 0L
            var i = 0
            while (i < 20) { // computation loop

                try {
                    yield()
                } catch (e: Exception) {
                    println("$i ${e.message}")
                }

                val currentTime = System.currentTimeMillis()
                if (currentTime >= nextPrintTime) {
                    println("I'm sleeping ${i++} ... CurrentThread: ${Thread.currentThread()}")
                    nextPrintTime = currentTime + 500L
                }
            }
        }
        delay(3000L)
        println("CurrentThread: ${Thread.currentThread()}")
        println("Before cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")
        val b1 = job.cancel() // cancels the job
        println("job cancel1: $b1")
        println("After Cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")

        delay(3000L)
        val b2 = job.cancel() // cancels the job, job already canceld, return false
        println("job cancel2: $b2")

        println("main: Now I can quit.")
    }

    /**
     * 取消一个协程任务时，如果有try {...} finally {...}代码块，那么finally {...}中的代码会被正常执行完毕
     */
    fun finallyCancelDemo() = runBlocking {
        val job = launch(CommonPool) {
            try {
                repeat(1000) { i ->
                    println("I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                println("I'm running finally")
                //挂起函数和以后的代码会生效
                delay(1000L)
                println("And I've delayed for 1 sec ?")
            }
        }
        delay(2000L)
        println("Before cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")
        job.cancel()
        println("After cancel, Job is alive: ${job.isActive}  Job is completed: ${job.isCompleted}")
        delay(2000L)
        println("main: Now I can quit.")
    }

    /**
     * 协程执行不可取消的代码块
     * 将相应的代码包装在 withContext (NonCancellable) {...}
     */
    fun testNonCancellable() = runBlocking {
        val job = launch(CommonPool) {
            try {
                repeat(1000) { i ->
                    println("I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                withContext(NonCancellable) {
                    println("I'm running finally")
                    delay(1000L)
                    println("And I've just delayed for 1 sec because I'm non-cancellable")
                }
            }
        }
        delay(2000L)
        println("main: I'm tired of waiting!")
        job.cancel()
        delay(2000L)
        println("main: Now I can quit.")
    }

    /**
     * 设置协程超时时间
     * withTimeout函数
     */
    fun testTimeouts() = runBlocking {
        withTimeout(3000L) {
            repeat(100) {
                println("I'm sleeping $it ...")
                delay(500L)
            }
        }
    }

}
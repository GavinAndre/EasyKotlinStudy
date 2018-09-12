package com.gavinandre.kotlinnetio

import kotlin.concurrent.thread

fun main(args: Array<String>) {

    //使用对象表达式
    object : Thread() {
        override fun run() {
            Thread.sleep(3000)
            println("A 使用 Thread 对象表达式: ${Thread.currentThread()}")
        }
    }.start()

    //使用Lambda表达式
    Thread {
        Thread.sleep(3000)
        println("B 使用 Lambda 表达式: ${Thread.currentThread()}")
    }.start()

    //使用Java Thread样板
    val t = Thread {
        Thread.sleep(2000)
        println("C 使用 Lambda 表达式:${Thread.currentThread()}")
    }
    t.isDaemon = false
    t.name = "CThread"
    t.priority = 3
    t.start()

    //使用Kotlin封装的thread
    thread(start = true, isDaemon = false, name = "DThread", priority = 3) {
        Thread.sleep(1000)
        println("D 使用 Kotlin 封装的函数 thread(): ${Thread.currentThread()}")
    }
}

/**
 * 同步方法
 */
@Synchronized
fun syncFun() {
}

class SyncBlock {
    /**
     * 同步块
     */
    fun syncBlock() {
        synchronized(this) {
            println()
        }
    }
}

@Volatile
private var running = false

fun start() {
    running = true
    thread(start = true) {
        while (running) {
            println("Still running: ${Thread.currentThread()}")
        }
    }
}

fun stop() {
    running = false
    println("Stopped: ${Thread.currentThread()}")
}
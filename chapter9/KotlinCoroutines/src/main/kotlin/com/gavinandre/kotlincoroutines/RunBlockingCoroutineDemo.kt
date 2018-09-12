package com.gavinandre.kotlincoroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.lang.String.format
import java.util.*

/**
 * runBlocking函数可实现类似主协程的功能
 */
fun main(args: Array<String>) = runBlocking<Unit> {
    //主协程
    println("${format(Date().toString())}: T0")

    //启动主协程
    launch(CommonPool) {
        //在common thread pool中创建协程
        println("${format(Date().toString())}: T1")
        delay(3000L)
        println("${format(Date().toString())}: T2 Hello,")
    }
    println("${format(Date().toString())}: T3 World!") //  当子协程被delay，主协程仍然继续运行

    delay(5000L)
    println("${format(Date().toString())}: T4")
}
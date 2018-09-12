package com.gavinandre.kotlincoroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.buildSequence
import kotlin.coroutines.experimental.coroutineContext

class ChannelsDemo {

    /**
     * Channel类似BlockingQueue,但通道有挂起的操作, 而不是阻塞的, 同时它可以关闭
     * Channel<Int>()背后调用的是会合通道RendezvousChannel()，会合通道中没有任何缓冲区。
     * send函数被挂起直到另外一个协程调用receive函数， 然后receive函数挂起直到另外一个协程调用send函数。它是一个完全无锁的实现
     */
    fun testChannel() = runBlocking {
        val channel = Channel<Int>()
        launch(CommonPool) {
            for (x in 1..10) {
                channel.send(x * x)
            }
        }
        println("channel = ${channel}")
        // here we print five received integers:
        repeat(10) {
            println(channel.receive())
        }
        println("Done!")
    }

    fun testClosingAndIterationChannels() = runBlocking {
        val channel = Channel<Int>()
        launch(CommonPool) {
            for (x in 1..5) channel.send(x * x)
            println("Before Close => isClosedForSend = ${channel.isClosedForSend}")
            channel.close() // 我们结束 sending
            println("After Close => isClosedForSend = ${channel.isClosedForSend}")
        }
        // 打印通道中的值，直到通道关闭
        for (x in channel) {
            println("${x} => isClosedForReceive = ${channel.isClosedForReceive}")
        }
        println("Done!  => isClosedForReceive = ${channel.isClosedForReceive}")
    }

    fun produceSquares() = produce<Int>(CommonPool) {
        for (x in 1..7) send(x * x)
    }

    fun consumeSquares() = runBlocking {
        val squares = produceSquares()
        squares.consumeEach { println(it) }
        println("Done!")
    }

    fun produceNumbers() = produce<Long>(CommonPool) {
        var x = 1L
        while (true) send(x++) // infinite stream of integers starting from 1
    }

    fun consumeNumbers(numbers: ReceiveChannel<Long>) = produce<Long>(CommonPool) {
        for (x in numbers) send(x * x)
    }

    fun testPipeline() = runBlocking {
        val numbers = produceNumbers() // produces integers from 1 and on
        val squares = consumeNumbers(numbers) // squares integers
        //for (i in 1..6) println(squares.receive())
        while (true) {
            println(squares.receive())
        }
        println("Done!")
        squares.cancel()
        numbers.cancel()
    }

    /**
     * 使用协程管道来生成一个无穷质数序列
     */
    fun numbersProducer(context: CoroutineContext, start: Int) = produce<Int>(context) {
        var n = start
        while (true) send(n++) // infinite stream of integers from start
    }

    fun filterPrimes(context: CoroutineContext, numbers: ReceiveChannel<Int>, prime: Int) = produce<Int>(context) {
        for (x in numbers) if (x % prime != 0) send(x)
    }

    fun producePrimesSequences() = runBlocking {
        var producerJob = numbersProducer(coroutineContext, 2)

        while (true) {
            val prime = producerJob.receive()
            print("${prime} \t")
            producerJob = filterPrimes(coroutineContext, producerJob, prime)
        }
    }

    fun produceBuffer() = runBlocking<Unit> {
        val channel = Channel<Int>(5) // 创建一个缓冲区容量为4的通道
        launch(coroutineContext) {
            repeat(10) {
                println("Sending $it")
                channel.send(it) // 当缓冲区已满的时候， send将会挂起
            }
        }
        delay(1000)
    }

    /**
     * 构建无穷惰性序列
     */
    fun fibonacciSequences() = runBlocking {
        val fibonacci = buildSequence {
            yield(1L)
            var current = 1L
            var next = 1L
            while (true) {
//                yield() 函数来产生连续的斐波纳契数
                yield(next)
                val tmp = current + next
                current = next
                next = tmp
            }
        }

        println(fibonacci.take(16).forEach { println("${it} \t") })
        println(fibonacci.take(16).toList())
    }
}
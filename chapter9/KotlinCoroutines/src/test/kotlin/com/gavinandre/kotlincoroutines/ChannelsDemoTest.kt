package com.gavinandre.kotlincoroutines

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ChannelsDemoTest {

    @Test
    fun test() {
        val cd = ChannelsDemo()
//        cd.testChannel()
//        cd.testClosingAndIterationChannels()
//        cd.consumeSquares()
//        cd.testPipeline()
//        cd.producePrimesSequences()
//        cd.produceBuffer()
        cd.fibonacciSequences()
    }
}
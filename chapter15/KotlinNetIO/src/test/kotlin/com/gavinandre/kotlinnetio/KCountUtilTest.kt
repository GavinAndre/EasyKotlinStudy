package com.gavinandre.kotlinnetio

import org.junit.Test

class KCountUtilTest {

    val filename = "唐诗三百首.txt"

    @Test
    fun countSummary() {
        println(KCountUtil.countSummary(filename))
    }

    @Test
    fun countChineseWordFreq() {
        println(KCountUtil.countChineseWordFreq(filename, 1))
        println(KCountUtil.countChineseWordFreq(filename, 2))
        println(KCountUtil.countChineseWordFreq(filename, 3))
        println(KCountUtil.countChineseWordFreq(filename, 4))
        println(KCountUtil.countChineseWordFreq(filename, 5))
        println(KCountUtil.countChineseWordFreq(filename, 6))
        println(KCountUtil.countChineseWordFreq(filename, 7))
    }

    @Test
    fun countEnglishWordFreq() {
        println(KCountUtil.countEnglishWordFreq(filename, 1))
        println(KCountUtil.countEnglishWordFreq(filename, 2))
        println(KCountUtil.countEnglishWordFreq(filename, 3))
        println(KCountUtil.countEnglishWordFreq(filename, 4))
        println(KCountUtil.countEnglishWordFreq(filename, 5))
        println(KCountUtil.countEnglishWordFreq(filename, 6))
        println(KCountUtil.countEnglishWordFreq(filename, 7))
    }
}
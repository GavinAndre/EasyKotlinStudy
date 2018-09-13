package com.gavinandre.kotlininteroperatewithjava

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MathToolsTest {
    @Test
    fun testISKeyWord() {
        //如果一个 Java 库使用了 Kotlin 关键字作为方法,可以使用反引号（`）字符转义它来调用该方法
        val b = MathTools().`is`(1)
    }
}
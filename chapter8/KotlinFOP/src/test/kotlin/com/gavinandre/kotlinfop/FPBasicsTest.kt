package com.gavinandre.kotlinfop

import com.gavinanere.kotlinfop.FPBasics
import com.gavinanere.kotlinfop.html
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FPBasicsTest {

    @Test
    fun test() {
        FPBasics.test()

        //带接收者的函数字面值
        html {
            body()
        }
    }
}
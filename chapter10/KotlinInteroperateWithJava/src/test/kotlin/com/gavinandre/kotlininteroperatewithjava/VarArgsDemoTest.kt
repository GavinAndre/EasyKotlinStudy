package com.gavinandre.kotlininteroperatewithjava

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class VarArgsDemoTest {

    @Test
    fun testVarArgsDemo() {
        val varArgsDemo = VarArgsDemo<Any?>()
        val array = arrayOf(0, 1, 2, 3)
        //使用展开运算符 * 来传递这个varargs
        val result = varArgsDemo.append(*array)
        println(result)
    }
}
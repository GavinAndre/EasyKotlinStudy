package com.gavinandre.kotlininteroperatewithjava

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RefectClassTest {

    /**
     * 可以使用 instance::class.java、ClassName::class.java 或者 instance.javaClass
     * 通过 java.lang.Class 来进入 Java 的反射类java.lang.Class， 之后我们就可以使用Java中的反射的功能特性了
     */
    @Test
    fun testGetterSetter() {
        val product = Product()
        val pClz = product::class.java
        println(pClz.canonicalName)
        pClz.declaredFields.forEach { println(it) }
        pClz.declaredMethods.forEach {
            println(it.name)
            it.parameters.forEach { println(it) }
        }
    }
}
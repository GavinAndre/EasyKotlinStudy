package com.gavinandre.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class InfixFunctionDemoTest {
    @Test
    fun testInfixFunction() {
        val person = Person("Gavin", 18)

        println(person.grow(2))

        println(person grow 2)
    }
}
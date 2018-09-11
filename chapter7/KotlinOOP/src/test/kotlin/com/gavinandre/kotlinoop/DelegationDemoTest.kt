package com.gavinandre.kotlinoop

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DelegationDemoTest {

    @Test
    fun test() {
        val subject = RealSubject("World")
        subject.hello()
        println("----------------------")
        val proxySubject = ProxySubject(subject)
        proxySubject.hello()
    }
}
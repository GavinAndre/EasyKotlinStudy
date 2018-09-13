package com.gavinandre.kotlininteroperatewithjava

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SAMFunctionalInterfaceTest {

    /**
     * 我们在Kotlin中，要某个函数做某件事时，会传一个函数参数给它。
     * 而在Java中，并不支持传送函数参数。通常Java的实现方式是将动作放在一个实现某接口的类中，
     * 然后将该类的一个实例传递给另一个方法。
     * 在大多数情况下，这些接口只有单个抽象方法（single abstract method），在Java中被称为SAM类型
     */
    @Test
    fun testSAMFunctionalInterface() {
        val runnable = Runnable { println("执行测试") } //调用Java的SAM接口方法
        val thread = Thread(runnable)
        thread.start()
    }
}
package com.gavinandre.kotlinoop

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DelegatePropertiesDemoTest {

    @Test
    fun test() {
        val n = NormalPropertiesDemo()
        println(n.content)
        n.content = "Lao tze"
        println(n.content)

        val e = DelegatePropertiesDemo()
        println(e.content)
        e.content = "Confucius"
        println(e.content)

        // 懒加载属性
        val synchronizedLazyImpl1 = lazy {
            println("lazyValueSynchronized1  3!")
            println("lazyValueSynchronized1  2!")
            println("lazyValueSynchronized1  1!")
            "Hello, lazyValueSynchronized1 ! "
        }

        val synchronizedLazyImpl2 = lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            println("lazyValueSynchronized1  3!")
            println("lazyValueSynchronized1  2!")
            println("lazyValueSynchronized1  1!")
            "Hello, lazyValueSynchronized1 ! "
        }

        val lazyValueSynchronized1: String by synchronizedLazyImpl1
        //第一次调用 get() 会执行已传递给 lazy() 的 lamda 表达式并记录下结果， 后续调用 get() 只是返回之前记录的结果
        println(lazyValueSynchronized1)
        println(lazyValueSynchronized1)

        val lazyValueSynchronized2: String by lazy {
            println("lazyValueSynchronized2  3!")
            println("lazyValueSynchronized2  2!")
            println("lazyValueSynchronized2  1!")
            "Hello, lazyValueSynchronized2 ! "
        }
        println(lazyValueSynchronized2)
        println(lazyValueSynchronized2)

        //如果初始化委托多个线程可以同时执行，不需要同步锁，使用LazyThreadSafetyMode.PUBLICATION
        val lazyValuePublication: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
            println("lazyValuePublication 3!")
            println("lazyValuePublication 2!")
            println("lazyValuePublication 1!")
            "Hello, lazyValuePublication ! "
        }
        println(lazyValuePublication)
        println(lazyValuePublication)

        //如果属性的初始化是单线程的，那么我们使用 LazyThreadSafetyMode.NONE 模式(性能最高)
        val lazyValueNone: String by lazy(LazyThreadSafetyMode.NONE) {
            println("lazyValueNone 3!")
            println("lazyValueNone 2!")
            println("lazyValueNone 1!")
            "Hello, lazyValueNone ! "
        }
        println(lazyValueNone)
        println(lazyValueNone)

        val ph = PostHierarchy()
        ph.level = "P1"
        ph.level = "P2"
        ph.level = "P3"
        println(ph.level) // P3
        ph.grade = "T1"
        ph.grade = "T2"
        ph.grade = "T3"
        println(ph.grade)
        ph.notChangeGrade = "T1"
        ph.notChangeGrade = "T2"
        ph.notChangeGrade = "T3"
        println(ph.notChangeGrade)
//        ph.name = null // error Null can not be a value of a non-null type String

        val account = Account(mapOf(
                "name" to "admin", "password" to "admin"))
        println("Account(name=${account.name}, password=${account.password})")

        val maccount = MutableAccount(mutableMapOf(
                "name" to "admin", "password" to "admin"))
        maccount.password = "root"
        println("MutableAccount(name=${maccount.name}, password = ${maccount.password})")
    }
}
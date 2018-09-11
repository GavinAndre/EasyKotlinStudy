package com.gavinandre.kotlinoop

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NestedClassesDemoTest {

    @Test
    fun test() {
        val one = NestedClassesDemo.Outer().one
        val two = NestedClassesDemo.Outer.Nested().getTwo()
        val three = NestedClassesDemo.Outer.Nested.Nested1().three
        val four = NestedClassesDemo.Outer.Nested.Nested1().getFour()
        println(one)
        println(two)
        println(three)
        println(four)

        val innerClass = NestedClassesDemo.Outer().Inner()
        innerClass.accessOuter()

        NestedClassesDemo.Outer.AnonymousInnerClassDemo().doRun()
        NestedClassesDemo.Outer.AnonymousInnerClassDemo().doStop()
        NestedClassesDemo.Outer.AnonymousInnerClassDemo().doWait()
        NestedClassesDemo.Outer.AnonymousInnerClassDemo().doNotify()
    }
}
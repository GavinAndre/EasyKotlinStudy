package com.gavinandre.typesystem

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TypeSystemKtTest {

    @Test
    fun testIs() {
        val len = strLen("abc")
        println(len)
        val lens = strLen(1)
        println(lens)
    }

    @Test
    fun testAs() {
        val foo = Foo()
        val goo = Goo()
        //true自己
        println(foo is Foo)
        //子类is父类=true
        println(goo is Foo)
        //父类is子类=false
        println(foo is Goo)
        //true自己
        println(goo is Goo)

//        val f2g = foo as Goo
//        println(f2g)
        val g2f = goo as Foo
        println(g2f)
    }
}

package com.gavinandre.typesystem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StringUtilKtTest {
    val StringUtilKt = StringUtilKt()

    @Test
    fun testGetLength1() {
//        StringUtilKt.getLength1(null)
        Assert.assertTrue(3 == StringUtilKt.getLength1("abc"))
    }

    @Test
    fun testGetLength2() {
        println(StringUtilKt.getLength2(null))
        Assert.assertTrue(3 == StringUtilKt.getLength2("abc"))
    }

    @Test
    fun testGetLength3() {
        println(StringUtilKt.getLength3(null))
        Assert.assertTrue(3 == StringUtilKt.getLength3("abc"))
    }
}
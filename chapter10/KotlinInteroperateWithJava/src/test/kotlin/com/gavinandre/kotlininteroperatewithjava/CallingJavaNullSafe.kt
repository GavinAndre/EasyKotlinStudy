package com.gavinandre.kotlininteroperatewithjava

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*


@RunWith(JUnit4::class)
class CallingJavaNullSafe {
    @Test
    fun testCallingJavaNullSafe() {
        val product = Product()
//        product.name = null
        product.category = "金融财务类"
        product.gmtCreated = Date()
        product.gmtModified = Date()
        println(JSONUtils.toJsonString(product))

        val name = product.name
        println("product name is ${name}")

        val eqName = name == "账务系统"
        println(eqName)

        name.substring(1)
        println(name?.substring(1))
    }

    @Test
    fun testNonCheckedException() {
        val jsonUtils = JSONUtils()
        jsonUtils.parseObject("{}")
        jsonUtils::class.java
    }
}

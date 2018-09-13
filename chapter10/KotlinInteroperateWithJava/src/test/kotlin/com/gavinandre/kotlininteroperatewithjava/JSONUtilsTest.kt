package com.gavinandre.kotlininteroperatewithjava

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class JSONUtilsTest {
    @Test
    fun testJSONUtils() {
        val userService = UserServiceImpl()
        val user = userService.findByName("admin")
        Assert.assertTrue(user.name == "admin")

        //kotlin调用java静态函数可以直接调用
        //java调用kotlin中object对象类中的函数需要加INSTANCE关键字
        val userJson = JSONUtils.toJsonString(user)
        println(userJson)
        Assert.assertTrue(userJson == "{\"name\":\"admin\",\"password\":\"admin\"}")

        user::class.java.canonicalName
        user.javaClass.annotatedSuperclass
    }
}
package com.gavinandre.kotlinoop

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import sun.invoke.empty.Empty

@RunWith(JUnit4::class)
class CompanionObjectDemoTest {

    @Test
    fun test() {
//        val admin = AdminUser()
        val adminUser = AdminUser.username
        val adminPassword = AdminUser.md5Password()
        println(adminUser)
        println(adminPassword)

        println(DataProcessor.FileUtils.userHome)
        println(DataProcessor.FileUtils.getFileContent("Empty File"))
//        val dp = DataProcessor()
//        dp.FileUtils.userHome // error, Nested object FileUtils cannot access object via reference

        val url = "http://www.baidu.com"
        val html1 = HttpUtils.getSync(url)
        println("html1=${html1}")
        HttpUtils.getAsync(url)

        println(distance(3.0, 4.0))

//        AnonymousObjectType().publicFoo().x // Unresolved reference 'x'

        countCompare()

        ClassA.create()

        ClassB.index
        ClassB.create()
        ClassB.get()
        ClassB.Companion.index
        ClassB.Companion.create()
        ClassB.Companion.get()

        ClassC.index
        ClassC.create()
        ClassC.get()
        ClassC.CompanyC.index
        ClassC.CompanyC.create()
        ClassC.CompanyC.get()

        MyClass.create() //"MyClass Created!"
        MyClass.Companion.create() // "MyClass Created!"
    }
}
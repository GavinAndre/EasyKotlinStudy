package com.gavinandre.kotlinoop

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DataClassDemoTest {
    @Test
    fun test() {
        val cook = Cook("Cook")
        println(cook.name)

        val dook = Dook("Dook")
        println(dook.name)
        val eook = Eook("Eook")
        println(eook.name)

        val book = Book("Book")
        val book2 = book.copy("Book2")
        println(book.name)
        println(book2.name)

        val gavin = User1("gavinandre", "Male", 1)
        println(gavin.name)
        println(gavin.gender)
        println(gavin.age)
        println(gavin.toString())
        println(gavin.validate())

        //copy()函数可以复制一个对象并改变部分属性,其余部分保持不变
        val olderGavin = gavin.copy(age = 2)
        val anotherGavin = gavin.copy(name = "Jacky", age = 10)

        val loginUser1 = LoginUser("Admin", "admin")
        println(loginUser1.component1())
        println(loginUser1.component2())
        println(loginUser1.name)
        println(loginUser1.password)
        println(loginUser1.toString())

        val loginUser2 = LoginUser(password = "root", name = "root")
        println(loginUser2.name)
        println(loginUser2.password)

        val loginUser3 = LoginUser()
        println(loginUser3.name)
        println(loginUser3.password)

//        数据类的结构
//        解构相当于 Component 函数的逆向映射
        val helen = User1("Helen", "Female", 15)
        val (name, gender, age) = helen
        println("$name, $gender, $age years of age")
    }
}
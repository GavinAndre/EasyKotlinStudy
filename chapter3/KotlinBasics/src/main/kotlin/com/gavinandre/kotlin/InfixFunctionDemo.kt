package com.gavinandre.kotlin

data class Person(val name: String, val age: Int)

//重载中缀操作符 (person grow 2)
infix fun Person.grow(years: Int): Person {
    return Person(name, age + years)
}
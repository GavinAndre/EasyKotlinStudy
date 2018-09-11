package com.gavinandre.kotlinoop


open class Base(type: String) {
    open fun doSomething() {}
}

class SubClass(type: String) : Base(type) {
    override fun doSomething() {
        super.doSomething()
    }
}

abstract class Animal {
    fun doEat() {
        println("Animal Eating")
    }
}

abstract class Plant {
    fun doEat() {
        println("Plant Eating")
    }
}

interface Runnable {
    fun doRun()
}

interface Flyable {
    fun doFly()
}

class Dog : Animal(), Runnable {
    override fun doRun() {
        println("Dog Running")
    }
}

class Eagle : Animal(), Flyable {
    override fun doFly() {
        println("Eagle Flying")
    }
}

//始祖鸟,能飞也能跑
class Archaeopteryx : Animal(), Runnable, Flyable {
    override fun doRun() {
        println("Archaeopteryx Running")
    }

    override fun doFly() {
        println("Archaeopteryx Flying")
    }
}
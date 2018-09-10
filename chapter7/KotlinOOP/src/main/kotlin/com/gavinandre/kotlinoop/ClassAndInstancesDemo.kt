package com.gavinandre.kotlinoop

class World

class World1 {
    val yin: Int = 0
    val yang: Int = 1
}

class World2 {
    val yin: Int = 0
    val yang: Int = 1
    fun plus(): Int {
        return yin + yang
    }
}

abstract class Person(var name: String, var age: Int) : Any() {
    abstract var addr: String
    abstract var weight: Float

    abstract fun doEat()
    abstract fun doWalk()

    open fun doSleep() {
        println("I am Sleeping ...")
    }

    /**
     * 默认final不能在子类被继承
     */
    fun doSwim() {
        println("I am Swimming ...")
    }
}

class Teacher(name: String, age: Int) : Person(name, age) {

    //    override var addr: String // error,需要初始化或声明为abstract
//    override var weight: Float // error,需要初始化或声明为abstract
    override var addr: String = "HangZhou"
    override var weight: Float = 100.0f

    override fun doEat() {
        println("Teacher is Eating ...")
    }

    override fun doWalk() {
        println("Teacher is Walking ...")
    }

    override fun doSleep() {
        super.doSleep()
        println("Teacher is Sleeping ...")
    }

    /**
     * 子类无法继承
     */
//    override fun doSwim() {
//        println("Teacher is Sleeping ...")
//    }
}

/**
 * 使用override关键字来表明是重写函数
 */
class Programmer(override var addr: String, override var weight: Float, name: String, age: Int) : Person(name, age) {

    override fun doEat() {
        println("Programmer is Eating ...")
    }

    override fun doWalk() {
        println("Programmer is Walking ...")
    }
}

abstract class Writer(override var addr: String, override var weight: Float, name: String, age: Int) : Person(name, age) {
    override fun doEat() {
        println("Programmer is Eating ...")
    }

    /**
     * 子类没有实现父类的抽象函数，则必须将子类也定义为为abstract类
     */
    abstract override fun doWalk()
}
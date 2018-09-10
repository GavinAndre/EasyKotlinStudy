package com.gavinandre.kotlinoop

/**
 * 主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字
 */
open class Student(var name: String, var age: Int) : Any() {
    //初始化代码可以放到init关键字作为前缀的初始化块中(initializer blocks)
    init {
        println("Student{name=$name,age=$age} created!")
    }


    open val weight: Float = 0.0f
}

annotation class MyAutowired

/**
 * 构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面
 */
class ElementaryStudent public @MyAutowired constructor(name: String, age: Int) : Student(name, age) {
    override var weight: Float = 80.0f

    constructor(name: String, age: Int, weight: Float) : this(name, age) {
        this.weight = weight
    }
}

/**
 * 次构造函数
 */
class MideleSchoolStudent {
    constructor(name: String, age: Int) {
    }
}

/**
 * 私有主构造函数
 */
class DontCreateMe private constructor(){
}



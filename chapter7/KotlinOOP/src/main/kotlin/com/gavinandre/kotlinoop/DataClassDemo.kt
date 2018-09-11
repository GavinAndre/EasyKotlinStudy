package com.gavinandre.kotlinoop

/**
 * name变量是无法被外部访问
 */
class Aook(name: String)

/**
 * 在类体中再声明一个变量进行赋值,这个变量就能被访问到
 */
class Cook(name: String) {
    val name = name
}

/**
 * 构造函数中带var、val修饰的变量，Kotlin编译器会自动为它们生成getter、setter函数
 */
class Dook(val name: String)

class Eook(var name: String)

data class Book(val name: String)
data class Fook(var name: String)

data class User1(val name: String, val gender: String, val age: Int) {
    fun validate(): Boolean {
        return true
    }
}

open class DBase
interface IBaseA
interface IBaseB

/**
 * 实现一个无参的构造函数，只要对所有的属性指定默认值即可
 */
data class LoginUser(val name: String = "", val password: String = "") : DBase(), IBaseA, IBaseB {

    var isActive = true

    constructor(name: String, password: String, isActive: Boolean) : this(name, password) {
        this.isActive = isActive
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }

    fun validate(): Boolean {
        return true
    }
}

/**
 * 主构造函数需要至少有一个参数
 */
//data class Gook // error, data class must have at least one primary constructor parameter
/**
 * 主构造函数的所有参数需要标记为 val 或 var
 */
//data class Hook(name: String)// error, data class must have only var/val property
/**
 * 数据类不能是抽象、开放、密封或者内部的
 */
//abstract data class Iook(val name: String) // modifier abstract is incompatible with data
//open data class Jook(val name: String) // modifier abstract is incompatible with data
//sealed data class Kook(val name: String)// modifier sealed is incompatible with data
//inner data class Look(val name: String)// modifier inner is incompatible with data

final data class Mook(val name: String) // Redundant modality modifier

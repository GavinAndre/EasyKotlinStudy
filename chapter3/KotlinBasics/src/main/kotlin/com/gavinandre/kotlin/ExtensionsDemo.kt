package com.gavinandre.kotlin

/**
 * 由于扩展没有实际的将成员插入类中，
 * 因此对扩展的属性来说，它的行为只能由显式提供的 getters/setters 定义
 */
val <T> List<T>.lastIndex: Int get() = size - 1

/**
 * 扩展不是真正的修改他们所扩展的类。
 * 我们定义一个扩展，其实并没有在一个类中插入新函数，
 * 仅仅是通过该类型的变量，用点.表达式去调用这个新函数。
 */
fun String.notEmpty(): Boolean {
    return !this.isEmpty()
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    //this对应该列表
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

class ExtensionsDemo {

    fun useExtensions() {
        println("123".notEmpty())
        println("".notEmpty())

        val mList1 = mutableListOf<Int>(1, 2, 3, 4, 5)
        println("Before Swap:")
        println(mList1)
        mList1.swap(0, mList1.size - 1)
        println("After Swap:")
        println(mList1)

        val mList2 = mutableListOf<String>("a12", "b34", "c56", "d78")
        println("Before Swap:")
        println(mList2)
        mList2.swap(1, 2)
        println("After Swap:")
        println(mList2)

        val mList3 = mutableListOf<Boolean>(true, false, true, false)
        println("Before Swap:")
        println(mList3)
        mList3.swap(0, mList3.lastIndex)
        println("After Swap:")
        println(mList3)
    }

    class Inner {
        fun useExtensions() {
            val mInnerList = mutableListOf<Int>(100, 200, 300, 400, 500)
            println("mInnerList.lastIndex= ${mInnerList.lastIndex}")
        }
    }

}
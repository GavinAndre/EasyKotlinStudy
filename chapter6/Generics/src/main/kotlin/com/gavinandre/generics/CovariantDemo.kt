package com.gavinandre.generics

/**
 * out T 等价于 ? extends T , 允许 <T子类> 转 <T>
 * in T 等价于 ? super T , 允许 <T父类> 转 <T>
 * * 等价于 ?
 */
interface Source<out T> {
    fun <T> nextT()
}

fun demo(str: Source<Int>) {
    //合法的类型协变
    val obj: Source<Number> = str
    //List接口使用<out T>定义泛型,实现协变
    val list: List<Number> = listOf(1, 2, 3)
}

/**
 * out T 生产者,只能读取
 * in T 消费者,只能写入
 */
fun copy(from: Array<out Any>, to: Array<in Any>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
        println(from[i])
        println(to[i])
    }
}

fun fill(dest: Array<in String>, value: String) {
    dest[dest.size - 1] = value
    dest.forEach { print(it) }
}
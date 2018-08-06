package com.gavinandre.collections

/**
 * 不可变列表
 */
fun immutableList() {
    val list1: List<Int> = listOf()
    println(list1)
    println(list1::class)
    val list2 = listOf(1)
    println(list2)
    println(list2::class)
    val list3 = listOf(1, 2, 3)
    println(list3)
    println(list3::class)
    val list4 = arrayListOf(1, 2, 3, 4)
    println(list4)
    println(list4::class)
}

/**
 * 可变列表
 */
fun mutableList() {
    val list1 = mutableListOf<Int>()
    println(list1)
    println(list1::class)
    val list2 = mutableListOf(1)
    println(list2)
    println(list2::class)
    val list3 = mutableListOf(1, 2, 3)
    println(list3)
    println(list3::class)
}

/**
 * 不可变转可变列表
 */
fun immutableMutableListConvert() {
    val list = listOf(1, 2, 3).toMutableList()
    list.add(4)
    list.add(5)
    println(list)
    println(list::class)
    list.toList()
    println(list::class)
}

/**
 * 使用Iterator迭代器遍历元素
 * 创建迭代器的代价小,被称为“轻量级”对象
 */
fun iterateList() {
    val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val iterator = list.iterator()
    println(iterator)
    while (iterator.hasNext()) {
        print(iterator.next())
    }
}

/**
 * 使用forEach遍历List元素
 * iterator迭代器语法糖
 */
fun foreachList() {
    val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    //以下等价
    list.forEach { print(it) }
    println()
    list.forEach({ print(it) })
    println()
    list.forEach(::print)
}

fun operateList() {
    println("add")
    val list = mutableListOf(1, 2, 3)
    list.add(4)
    println(list)
    list.add(0, 0)
    println(list)
    println("remove")
    list.remove(4)
    println(list)
    list.removeAt(0)
    println(list)
    list.removeAll(listOf(2, 3))
    println(list)
    println("addAll")
    list.addAll(listOf(2, 3))
    println(list)
    println("set")
    list.set(0, 3)
    println(list)
    println("clear")
    list.clear()
    println(list)
    //取交集
    println("retainAll")
    val mList1 = mutableListOf(1, 2, 3, 4, 5, 6)
    val mList2 = mutableListOf(3, 4, 5, 6, 7, 8, 9)
    println(mList1.retainAll(mList2))
    println(mList1)
    println("contains")
    val mList = listOf(1, 2, 3, 4, 5, 6, 7)
    println(mList.contains(1))
    //查找下标对应的元素
    println("elementAt")
    println(mList.elementAt(6))
    println(mList.elementAtOrElse(7) { 8 })
    println(mList.elementAtOrNull(9))
    println("first")
    println(mList.first())
    println(listOf<Int>().firstOrNull())
    println(mList.first { it % 2 == 0 })
    println(mList.firstOrNull { it > 100 })
    println("indexOf")
    println(mList.indexOf(6))
    println(mList.indexOf(0))
    val iList = listOf("abc", "xyz", "xjk", "pqk")
    //返回第一个符合条件的元素下标，没有就返回-1
    println(iList.indexOfFirst { it.contains("x") })
    println(iList.indexOfFirst { it.contains("k") })
    println(iList.indexOfFirst { it.contains("e") })
    //返回最后一个符合条件的元素下标，没有就返回-1
    println(iList.indexOfLast { it.contains("x") })
    println(iList.indexOfLast { it.contains("k") })
    println(iList.indexOfLast { it.contains("e") })
    println("last")
    println(mList.last())
    println(mList.last { it == 1 })
    println(mList.lastOrNull { it > 10 })
    val lList = listOf("abc", "dfg", "jkl", "abc", "bbc", "wer")
    println(lList.lastIndexOf("abc"))
    println("single")
    //该集合如果只有1个元素，则返回该元素。否则，抛异常
    val sList1 = listOf(1)
    println(sList1.single())
    //返回符合条件的单个元素，如有没有符合的抛异常NoSuchElementException，或超过一个的抛异常
    val sList2 = listOf(1, 2, 3, 4, 7, 5, 6, 7, 8)
    println(sList2.single { it == 1 })
    println(sList2.singleOrNull { it == 7 })
    println(sList2.singleOrNull { it == 10 })
}

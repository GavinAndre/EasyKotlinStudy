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

fun operateList1() {
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

fun operateList2() {
    val emptyList = listOf<Int>()
    val sList = listOf("a", "b", "c")
    val list1 = listOf(1)
    val list3 = listOf(1, 2, 3)
    val list4 = listOf(1, 2, 3, 4)
    val list5 = listOf(0, 2, 4, 6, 8)
    val list6 = listOf(0, 2, 4, 6, 8, 9)
    val list9 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val hList = listOf(100, -500, 300, 200)
    println("any")
    //判断集合中是否有满足条件的元素
    println(emptyList.any())
    println(list1.any())
    println(list3.any { it % 2 == 0 })
    println(list3.any { it > 4 })
    println("all")
    //判断集合中的元素是否都满足条件
    println(list5.all { it % 2 == 0 })
    println(list5.all { it > 4 })
    println("none")
    //判断集合中所有元素都不满足条件
    println(emptyList.none())
    println(list5.none { it % 2 == 1 })
    println(list5.none { it > 0 })
    println("count")
    println(list6.count())
    println(list6.count { it % 2 == 0 })
    println("reduce")
    //累计运算
    println(list9.reduce { acc, i -> acc + i })
    println(list9.reduce { acc, i -> acc * i })
    println(sList.reduce { acc, s -> acc + s })
    println(sList.reduceRight { acc, s -> s + acc })
    println("fold")
    //带初始值的累计运算
    println(list4.fold(100) { acc, i -> acc + i })
    println(sList.foldRight("xyz") { s, pre -> pre + s })
    println("forEach")
    list9.forEach { value -> if (value > 7) println(value) }
    list9.forEachIndexed { index, value -> if (value > 8) println("value of index $index is $value, greater than 8") }
    println("max")
    println(list9.max())
    println(sList.max())
    println("maxBy")
    //根据表达式的最大值返回元素值
    println(hList.maxBy { it })
    println(hList.maxBy { it * (1 - it) })
    println(hList.maxBy { it * it })
    println("min")
    println(list9.min())
    println(sList.min())
    println("minBy")
    //根据表达式的最小值返回元素值
    println(hList.minBy { it })
    println(hList.minBy { it * (1 - it) })
    println(hList.minBy { it * it })
    println("sumBy")
    println(list4.sumBy { it })
    //累加表达式的值
    println(list4.sumBy { it * it })
}

/**
 * 过滤操作符都是返回子集合(不改变自身集合)
 */
fun filterList() {
    val sList = listOf("a", "b", "c")
    val list6 = listOf(1, 2, 4, 6, 8, 9)
    val list7 = listOf(1, 2, 3, 4, 5, 6, 7)
    val list8 = listOf(2, 4, 6, 8, 9, 11, 12, 16)
    println("take")
    //挑出该集合前n个元素的子集合
    println(sList.take(2))
    println(sList.take(10))
    println(sList.take(0))
    println("takeWhile")
    //正向取满足条件的元素，遇到不满足的元素，直接终止循环，并返回子集合
    println(list6.takeWhile { it % 2 == 0 })
    println(list6.takeWhile { it % 2 == 1 })
    println(list8.takeWhile { it % 2 == 0 })
    println("takeLast")
    println(list8.takeLast(2))
    println(list8.takeLast(10))
    println(list8.takeLast(0))
    println("takeLastWhile")
    //正向取满足条件的元素，遇到不满足的元素，直接终止循环，并返回子集合
    println(list6.takeLastWhile { it % 2 == 0 })
    println(list6.takeLastWhile { it % 2 == 1 })
    println(list8.takeLastWhile { it % 2 == 0 })
    println("drop")
    //去除前n个元素返回剩下的元素的子集合
    println(list8.drop(5))
    println(list8.drop(10))
    println(list8.drop(0))
    println("dropWhile")
    //去除满足条件的元素，当遇到一个不满足条件的元素时，中止操作，返回剩下的元素子集合。
    println(list8.dropWhile { it % 2 == 0 })
    println("dropLast")
    println(list8.dropLast(3))
    println(list8.dropLast(10))
    println(list8.dropLast(0))
    println("dropLastWhile")
    println(list8.dropLastWhile { it % 2 == 0 })
    println("slice")
    //取开始下标至结束下标元素子集合
    println(list8.slice(1..3))
    println(list8.slice(2..7))
    println(list8.slice(listOf(2, 4, 6)))
    println("filterTo")
    //过滤出满足条件的元素并赋值给destination后返回destination
    val dest = mutableListOf<Int>()
    println(list7.filterTo(dest) { it > 3 })
    println("filter")
    //过滤出满足条件的元素组成的子集合
    println(list7.filter { it > 3 })
    println("filterNot")
    println(list7.filterNot { it > 3 })
    println("filterNotNull")
    //过滤掉null元素
    val nullList = listOf(1, 3, null)
    println(nullList)
    println(nullList.filterNotNull())
}

fun mapList() {
    val list7 = listOf(1, 2, 3, 4, 5, 6, 7)
    val NullList = listOf("a", "b", null, "x", null, "z")
    val sList = listOf("a", "b", "c")
    println("map")
    //将集合中的元素通过转换函数transform映射后的结果，存到一个集合中返回
    println(list7.map { it })
    println(list7.map { it * it })
    println(list7.map { it + 10 })
    println("mapIndex")
    println(list7.mapIndexed { index, it -> index * it })
    println("mapNotNull")
    println(NullList.mapNotNull { it })
    println("flatMap")
    println(sList.map { it -> listOf(it + 1, it + 2, it + 3) })
    println(sList.flatMap { it -> listOf(it + 1, it + 2, it + 3) })
    //等价于map+flatten
    //    println(sList.map { it -> listOf(it + 1, it + 2, it + 3) }.flatten())
}

fun groupList() {
    val words = listOf("a", "abc", "ab", "def", "abcd")
    println(words.groupBy { it.length })
    println(words.groupBy({ it.length }, { it.contains("b") }))
    //Pair(“key”,”value”) 等价于 “key” to “value”
    val programmer = listOf("K&R" to "C", Pair("Bjar", "C++"), "Linus" to "C", "James" to "Java")
    println(programmer.groupBy({ it.second }, { it.first }))
    //统计列表的元素单词中首字母出现的频数
    val words1 = "one two three four five six seven eight nine ten".split(' ')
    println(words1.groupingBy { it.first() }.eachCount())
}
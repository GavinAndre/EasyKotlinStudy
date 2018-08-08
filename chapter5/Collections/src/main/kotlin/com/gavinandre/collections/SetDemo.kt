package com.gavinandre.collections

fun emptySet() {
    val emptySet = emptySet<Int>()
    println(emptySet)
    println(emptySet.size)
    println(emptySet.isEmpty())
    println(emptySet.hashCode())
}

fun createSet() {
    val list = listOf(1, 1, 2, 3, 3)
    println(list)
    //Set中的元素不可重复
    val set = setOf(1, 1, 2, 3, 3)
    println(set)
    //list去重
    println(list.toSet())
    val s = setOf<Int>()
    println(s)
    val s1 = setOf<Int>(1)
    println(s1)
    //可变set
    val mutableSet = mutableSetOf(1, 1, 2, 3, 3)
    println(mutableSet)
    //HashSet : 该类按照哈希算法来存取集合中的对象，存取速度较快。
    val hs = hashSetOf(1, 3, 2, 7)
    println(hs)
    println(hs::class)
    //LinkedHashSet：具有HashSet的查询速度，且内部使用链表维护元素的顺序，在对Set元素进行频繁插入、删除的场景中使用。
    val ls = linkedSetOf(1, 3, 2, 7)
    println(ls)
    println(ls::class)
    val ms = mutableSetOf(1, 3, 2, 7)
    println(ms)
    println(ms::class)
    //TreeSet : 该类实现了SortedSet接口，能够对集合中的对象进行排序。
    val ss = sortedSetOf(1, 3, 2, 7)
    println(ss)
    println(ss::class)
}

fun operateSet() {
    val ms = mutableSetOf(1, 3, 2, 7)
    println(ms + 10)
    println(ms - 1)
    println(ms + listOf(8, 9))
    println(ms - listOf(8, 9))
    println(ms - listOf(1, 3))
}
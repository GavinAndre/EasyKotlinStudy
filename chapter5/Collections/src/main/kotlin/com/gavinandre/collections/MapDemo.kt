package com.gavinandre.collections

fun createMap() {
    val map1 = mapOf<String, Int>()
    println(map1.size)
    println(map1.isEmpty())
    val map2 = emptyMap<String, Int>()
    println(map2.size)
    println(map2.isEmpty())
    //空map相等
    println(map1 == map2)
    val map = mapOf(Pair(1, "x"), 2 to "y", 3 to "z")
    println(map)
    println(map[1])
    println(map[3])
    println(map.size)
    println(map.keys)
    println(map.values)
    println(map.entries)
    map.entries.forEach { println("key=" + it.key + " value=" + it.value) }
    println("MutableMap")
    //mutableMapOf直接调用LinkedHashMap
    val mMap = mutableMapOf<Int, Any?>()
    println(mMap.isEmpty())
    mMap[1] = "X"
    mMap[2] = 1
    mMap[1] = "Y"
    println(mMap)
    println("HashMap")
    //HashMap是基于哈希表（hash table）的 Map 接口的实现,允许使用 null 值和 null 键
    val hMap: HashMap<Int, String> = hashMapOf(1 to "x", 2 to "y", 3 to "z")
    println(hMap)
    println("LinkedHashMap")
    //LinkedHashMap继承HashMap，并使用链表实现维护内部顺序
    val lMap: LinkedHashMap<Int, String> = linkedMapOf(1 to "x", 2 to "y", 3 to "z")
    println("SortedMap")
    //使用红黑二叉树（red-black tree）的 Map 接口的实现
    val sMap = sortedMapOf(Pair("c", 3), Pair("b", 2), Pair("d", 1))
    println("get")
    println(mMap.get(99))
    println(mMap.getOrDefault(99, 99))
}

fun operateMap() {
    val map = mapOf("x" to 1, "y" to 2, "z" to 3)
    println("containsKey")
    println(map.containsKey("x"))
    println(map.containsKey("j"))
    println("containsValue")
    println(map.containsValue(2))
    println(map.containsValue(20))
    println("component")
    map.entries.forEach { println("key=" + it.component1() + " value=" + it.component2()) }
    println("pair")
    map.entries.forEach { println(it.toPair()) }
    val mMap = mutableMapOf<String, Int?>()
    println("getOrElse")
    println(mMap.getOrElse("x") { 1 })
    //println("getValue")
    //通过key获取值,没有则抛异常
    //println(mMap.getValue("v"))
    println("getOrPut")
    println(mMap.getOrPut("v") { 2 })
    println(mMap)
    println("iterator")
    for ((k, v) in map) {
        println("key=$k, value=$v")
    }
    println("mapKeys")
    //把Map的Key设置为通过转换函数transform映射之后的值
    //有任意两个key通过映射之后相等了，那么后面的key将会覆盖掉前面的key
    val map4: Map<Int, String> = mapOf(1 to "a", 2 to "b", 3 to "c", -1 to "z")
    println(map4.mapKeys { it.key * 10 })
    println("mapValues")
    println(map4.mapValues { it.value + '$' })
    println("filterKeys")
    println(map4.filterKeys { it > 0 })
    println("filterValues")
    println(map4.filterValues { it > "b" })
    println("filter")
    println(map4.filter { it.key > 0 && it.value > "b" })
    println("toMap")
    //把持有Pair的Iterable集合转换为Map
    val pairList = listOf(Pair(1, "a"), Pair(2, "b"), Pair(3, "c"))
    println(pairList)
    val pairMap = pairList.toMap()
    println(pairMap)
    println("toMutableMap")
    val mPairMap = pairMap.toMutableMap()
    mPairMap.put(4, "x")
    println(mPairMap)
    println("plus")
    println(map4 + Pair(10, "g"))
    println(map4 + listOf(Pair(9, "s"), Pair(10, "w")))
    println(map4 + arrayOf(Pair(9, "s"), Pair(10, "w")))
    println(map4 + sequenceOf(Pair(9, "s"), Pair(10, "w")))
    println(map4 + mapOf(9 to "s", 10 to "w"))
    val mMap4 = map4.toMutableMap()
    mMap4 += Pair(10, "g")
    println(mMap4)
    mMap4 += listOf(Pair(9, "s"), Pair(10, "w"))
    println(mMap4)
    mMap4 += arrayOf(Pair(9, "s"), Pair(10, "w"))
    println(mMap4)
    mMap4 += sequenceOf(Pair(9, "s"), Pair(10, "w"))
    println(mMap4)
    mMap4 += mapOf(9 to "s", 10 to "w")
    println(mMap4)
    println("put")
    //不存在则添加并返回null
    println(mMap4.put(99, "q"))
    //存在更新并返回更新前的value
    println(mMap4.put(1, "f"))
    println("putAll")
    mMap4.putAll(listOf(Pair(1, "aa"), Pair(19, "bb")))
    println(mMap4)
    println("remove")
    //不存在则null
    println(mMap4.remove(100))
    //存在则删除并返回删除前的value
    println(mMap4.remove(-1))
    println(mMap4)
    println("clear")
    mMap4.clear()
    println(mMap4)
}

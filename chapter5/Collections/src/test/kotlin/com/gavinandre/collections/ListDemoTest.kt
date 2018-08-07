package com.gavinandre.collections

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListDemoTest {

    @Test
    fun testImmutableListDemo() {
        immutableList()
    }

    @Test
    fun testMutableListDemo() {
        mutableList()
    }

    @Test
    fun testImmutableMutableListConvert() {
        immutableMutableListConvert()
    }

    @Test
    fun testIterateList() {
        iterateList()
    }

    @Test
    fun testForEachList() {
        foreachList()
    }

    @Test
    fun testOperateList1() {
        operateList1()
    }

    @Test
    fun testOperateList2() {
        operateList2()
    }

    @Test
    fun testFilterList() {
        filterList()
    }

    @Test
    fun testMapList() {
        mapList()
    }

    @Test
    fun testGroupList() {
        groupList()
    }

}
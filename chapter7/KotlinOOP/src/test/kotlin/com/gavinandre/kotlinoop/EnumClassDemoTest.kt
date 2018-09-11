package com.gavinandre.kotlinoop

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EnumClassDemoTest {

    @Test
    fun test() {
        val north = Direction.NORTH
        println(north.name)
        println(north.ordinal)
        println(north is Direction)

        val red = Color.RED
        println(red.rgb)

        val s = ActivityLifeState.onCreate
        println(s.signal())

        val rgbs = enumValues<RGB>().joinToString { "${it.name} : ${it.ordinal}" }
        println(rgbs)

        val colors = enumValues<Color>().joinToString { "${it.rgb}:${it.name}:${it.ordinal}" }
        println(colors)
    }
}
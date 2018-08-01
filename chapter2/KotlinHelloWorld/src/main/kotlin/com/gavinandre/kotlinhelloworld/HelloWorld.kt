package com.gavinandre.kotlinhelloworld

import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
    println("Hello,World!")
    println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
}
package com.gavinandre.kotlin

fun whileDemo() {
    var x = 10
    while (x > 0) {
        x--
        println(x)
    }

    var y = 10
    do {
        y += 1
        println(y)
    } while (y < 20)
}

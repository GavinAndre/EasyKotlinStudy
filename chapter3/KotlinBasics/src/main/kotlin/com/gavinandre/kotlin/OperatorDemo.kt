package com.gavinandre.kotlin

class OperatorDemo {

}

data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

data class Counter(var index: Int)

operator fun Counter.plus(increment: Int): Counter {
    return Counter(index + increment)
}

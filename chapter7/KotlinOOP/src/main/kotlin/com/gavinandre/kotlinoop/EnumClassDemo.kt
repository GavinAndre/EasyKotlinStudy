package com.gavinandre.kotlinoop

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class RGB {
    RED, GREEN, BLUE
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

/**
 * 枚举常量声明匿名类
 */
enum class ActivityLifeState {
    onCreate {
        override fun signal() = onCreate
    },
    onStart {
        override fun signal() = onStart
    },
    onStop {
        override fun signal() = onStop
    },
    onDestroy {
        override fun signal() = onDestroy
    };

    abstract fun signal(): ActivityLifeState
}
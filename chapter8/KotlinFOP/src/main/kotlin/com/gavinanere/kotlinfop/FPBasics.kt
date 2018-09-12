package com.gavinanere.kotlinfop

object FPBasics {

    fun double(x: Int): Int {
        return 2 * x
    }

    /**
     * 函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体
     */
    fun double1(x: Int): Int = x * 2

    /**
     * 返回类型可由编译器推断
     */
    fun double2(x: Int) = x * 2


    /**
     * 扩展函数
     */
    fun String.swap(index1: Int, index2: Int): String {
        val charArray = this.toCharArray()
        val tmp = charArray[index1]
        charArray[index1] = charArray[index2]
        charArray[index2] = tmp
        return FPBasics.charArrayToString(charArray)
    }

    fun charArrayToString(charArray: CharArray): String {
        var result = ""
        charArray.forEach { it -> result += it }
        return result
    }

    fun powerOf(number: Int, exponent: Int): Int {
        return Math.pow(number.toDouble(), exponent.toDouble()).toInt()
    }

    fun add(x: Int = 0, y: Int = 0): Int {
        return x + y
    }

    fun reformat(str: String,
                 normalizeCase: Boolean = true,
                 upperCaseFirstLetter: Boolean = true,
                 divideByCamelHumps: Boolean = false,
                 wordSeparator: Char = ' ') {
    }

    /**
     * Unit 类似 void
     */
    fun printHello(name: String?): Unit {
        if (name != null)
            println("Hello ${name}")
        else
            println("Hi there!")
        // `return Unit` 或者 `return` 是可选的
    }

    /**
     * 可变数量的参数(Varargs)
     * 函数的参数（通常是最后一个）可以用 vararg 修饰符标记
     */
    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) { // ts is an Array
            result.add(t)
        }
        return result
    }

    fun sum(x: Int, y: Int, z: Int): Int {
        val delta = 0
        fun add(a: Int, b: Int): Int {
            return a + b + delta
        }
        return add(x + add(y, z))
    }

    fun isOdd(x: Int): Boolean {
        return x % 2 == 1
    }

    fun sumGTZero(c: Iterable<Int>): Int {
        var sum = 0
        c.filter { it > 0 }.forEach {
            sum += it
        }
        return sum
    }

    /**
     * 尾递归tailrec
     */
    tailrec fun findFixPoint(x: Double = 1.0): Double
            = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x)) // 函数必须将其自身调用作为它执行的最后一个操作

    fun test() {
        val doubleTwo = FPBasics.double(2)
        println("double(2) = $doubleTwo")

        val str = "abcd"
        val swapStr = str.swap(0, str.lastIndex)
        println("str.swap(0, str.lastIndex) = $swapStr")

        val eight = powerOf(2, 3)
        println("powerOf(2,3)=$eight")

        val zero = add()
        val one = add(1)
        val two = add(1, 1)
        println("add() = $zero")
        println("add(1) = $one")
        println("add(1,1) = $two")

        reformat(str)
        reformat(str, true, true, false, '_')
        reformat(str, wordSeparator = '_')

        val list = asList(1, 2, 3)

        println("sum(1,2,3) = ${sum(1, 2, 3)}")

        val list1 = listOf(1, 2, 3, 4, 5)

        //高阶函数
        list1.filter(FPBasics::isOdd)
        //匿名函数
        list1.filter((fun(x: Int): Boolean {
            return x % 2 == 1
        }))
        //Lambda表达式
        list1.filter {
            it % 2 == 1
        }

        //使用Lambda表达式定义一个函数字面值
        val sum1 = { x: Int, y: Int -> x + y }
        println(sum1(1, 1))

        //使用嵌套的Lambda表达式来定义一个柯里化的sum函数
        val sum2 = { x: Int -> { y: Int -> x + y } }
        println(sum2(1)(1))

        val sum3 = sumGTZero(list1)
        println(sum3)

        findFixPoint()
    }

}

open class DefaultParamBase {
    open fun add(x: Int = 0, y: Int = 0): Int {
        return x + y
    }
}

class DefaultParam : DefaultParamBase() {
    override fun add(x: Int, y: Int): Int { //不能有默认值
        return super.add(x, y)
    }
}

class HTML {
    fun body() {
        println("HTML BODY")
    }
}

/**
 * val sum = fun Int.(other: Int): Int = this + other
 * 1.sum(1)
 */
fun html(init: HTML.() -> Unit): HTML { // HTML.()中的HTML是接受者类型
    val html = HTML() //创建接受者对象
    html.init()       //将该接收者对象传给该 lambda
    return html
}


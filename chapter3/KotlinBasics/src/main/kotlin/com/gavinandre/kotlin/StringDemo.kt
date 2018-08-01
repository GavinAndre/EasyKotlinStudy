package com.gavinandre.kotlin

class StringDemo {
    fun rawString(): String {
        //原始字符串用"""分隔,支持换行符和任何其他字符
        val rawString = """
fun helloWorld(val name: String) {
    println("Hello World!")
}
        """.trimIndent()
        return rawString
    }

    fun templateString(rawString: String): String {
        //表达式用${expression}来作为模板
        val fooTemplateString = "$rawString has ${rawString.length} characters"
        return fooTemplateString
    }
}
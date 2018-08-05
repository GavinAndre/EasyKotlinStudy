package com.gavinandre.kotlin

class StringDemo {
    //    原始字符串用"""分隔,支持换行符和任何其他字符
    fun rawString1(): String {
        //        把字符串行的左边空白对齐切割
        val rawString = """
fun helloWorld(val name: String) {
    println("Hello World!")
}
        """.trimIndent()
        return rawString
    }

    fun rawString2(): String {
        //        把字符串行边界字符前的字符对齐切割
        val rawString = """
              |Hello
        |World
}
        """.trimMargin()
        return rawString
    }

    fun templateString(rawString: String): String {
        //表达式用${expression}来作为模板
        val fooTemplateString = "$rawString has ${rawString.length} characters"
        return fooTemplateString
    }
}
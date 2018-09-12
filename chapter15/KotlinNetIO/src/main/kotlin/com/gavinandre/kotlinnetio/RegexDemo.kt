package com.gavinandre.kotlinnetio

fun main(args: Array<String>) {
    // Regex构造函数
    val r1 = Regex("[a-z]+")
    val r2 = Regex("[a-z]+", RegexOption.IGNORE_CASE)
    // String 的 toRegex 扩展函数
    val r3 = "[A-Z]+".toRegex()

    // matches
    // 输入字符串全部匹配正则表达式返回 true , 否则返回 false
    println(r1.matches("ABCzxc"))
    println(r2.matches("ABCzxc"))
    println(r3.matches("GGMM"))

    val re = Regex("[0-9]+")

    // containsMatchIn
    // 输入字符串中至少有一个匹配就返回true，没有一个匹配就返回false
    println(re.containsMatchIn("012Abc"))
    println(re.containsMatchIn("Abc"))

    // matchEntire
    // 输入字符串全部匹配正则表达式返回 一个MatcherMatchResult对象，否则返回 null
    println(re.matchEntire("1234567890"))
    println(re.matchEntire("1234567890")?.value)
    println(re.matchEntire("1234567890!"))

    // replace(input: CharSequence, replacement: String): String
    // 把输入字符串中匹配的部分替换成replacement的内容
    println(re.replace("12345XYZ", "abcd"))

    // replace(input: CharSequence, transform: (MatchResult) -> CharSequence): String
    // 把输入字符串中匹配到的值，用函数 transform映射之后的新值替换
    println(re.replace("9XYZ8") { (it.value.toInt() * it.value.toInt()).toString() })

    // find
    // 返回输入字符串中第一个匹配的MatcherMatchResult对象
    println(re.find("123XYZ987abcd7777"))
    println(re.find("123XYZ987abcd7777")?.value)

    // findAll
    // 返回输入字符串中所有匹配的值的MatchResult的序列
    println(re.findAll("123XYZ987abcd7777"))
    re.findAll("123XYZ987abcd7777").forEach {
        println(it.value)
    }

    // 使用Java 正则表达式类
    val p = re.toPattern()
    val m = p.matcher("888ABC999")
    while (m.find()) {
        val d = m.group()
        println(d)
    }
}
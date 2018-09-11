package com.gavinandre.kotlinoop

import okhttp3.*
import sun.misc.BASE64Encoder
import java.io.File
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Kotlin中没有 静态属性和方法，但是也提供了实现类似于单例的功能，我们可以使用关键字 object 声明一个object对象
 */
object User {
    val username: String = "admin"
    val password: String = "admin"
}

object AdminUser {
    val username: String = "admin"
    val password: String = "admin"
    fun getTimestamp() = SimpleDateFormat("yyyyMMddHHmmss".format(Date()))
    fun md5Password() = EncoderByMd5(password + getTimestamp())
}

@Throws(NoSuchAlgorithmException::class, UnsupportedEncodingException::class)
fun EncoderByMd5(str: String): String {
    val md5 = MessageDigest.getInstance("MD5")
    val base64en = BASE64Encoder()
    val newstr = base64en.encode(md5.digest(str.toByteArray(charset("utf-8"))))
    return newstr
}

class DataProcessor {
    fun process() {
        println("Process Data")
    }

    object FileUtils {
        val userHome = "/home/gavinandre/"

        fun getFileContent(file: String): String {
            var content = ""

            val f = File(userHome + file)
            f.forEachLine { content += it + "\n" }
            return content
        }
    }

    companion object StringUtils {
        fun isEmpty(s: String): Boolean {
            return s.isEmpty()
        }
    }
}

object HttpUtils {
    val client = OkHttpClient()

    @Throws(Exception::class)
    fun getSync(url: String): String? {
        val request = Request.Builder()
                .url(url)
                .build()

        val response = client.newCall(request).execute()
        if (!response.isSuccessful()) throw IOException("Unexpected code $response")

        val responseHeaders = response.headers()
        for (i in 0..responseHeaders.size() - 1) {
            println(responseHeaders.name(i) + ": " + responseHeaders.value(i))
        }
        return response.body()?.string()
    }

    @Throws(Exception::class)
    fun getAsync(url: String) {
        var result: String? = ""

        val request = Request.Builder()
                .url(url)
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException?) {
                e?.printStackTrace()
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful()) throw IOException("Unexpected code $response")

                val responseHeaders = response.headers()
                for (i in 0..responseHeaders.size() - 1) {
                    println(responseHeaders.name(i) + ": " + responseHeaders.value(i))
                }
                result = response.body()?.string()
                println(result)
            }
        })
    }
}

fun distance(x: Double, y: Double): Double {
    //匿名object
    val porigin = object {
        var x = 0.0
        var y = 0.0
    }
    return Math.sqrt((x - porigin.x) * (x - porigin.x) + (y - porigin.y) * (y - porigin.y))
}

class AnonymousObjectType {
    // 私有函数,返回的是匿名object类型
    private fun privateFoo() = object {
        val x: String = "x"
    }

    // 公有函数,返回的类型是Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    // 匿名对象只可以用在本地和私有作用域中声明的类型
    fun test() {
        val x1 = privateFoo().x //Works
//        val x2 = publicFoo().x //Unresolved reference: x
    }
}

fun countCompare() {
    var list = mutableListOf(1, 4, 3, 7, 11, 9, 10, 20)
    var countCompare = 0
    Collections.sort(list, object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            countCompare++
            println("countCompare=$countCompare")
            println(list)
            return o1.compareTo(o2)
        }
    })
}

class ClassA {
    companion object Factory {
        fun create(): ClassA = ClassA()
    }

//    companion object Faceory2 { // error, only 1 companion object is allowed per class
//        fun create(): MyClass = MyClass()
//    }
}

class ClassB {
    companion object {
        var index = 1
        fun create(): ClassB = ClassB()
        fun get() = "Hi, I am CompanyB"
    }
}

class ClassC {
    var index = 1
    fun get(index: Int): Int {
        return 1
    }

    /**
     * 指定伴生对象的名称
     */
    companion object CompanyC {
        var index = 0
        fun create(): ClassC = ClassC()
        fun get() = "Hi, I am CompanyC"
    }
}

interface BeanFactory<T> {
    fun create(): T
}

/**
 * 伴生对象的初始化是在相应的类被加载解析时，与 Java 静态初始化器的语义相匹配
 * 即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们仍然是真实对象的实例成员。而且，还可以实现接口
 */
class MyClass {
    companion object : BeanFactory<MyClass> {
        override fun create(): MyClass {
            println("MyClass Created!")
            return MyClass()
        }
    }
}
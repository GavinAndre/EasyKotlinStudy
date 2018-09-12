package com.gavinandre.kotlinnetio

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.File

@RunWith(JUnit4::class)
class KNetUtilTest {

    @Test
    fun test() {
        println(KNetUtil.getUrlContent("https://www.baidu.com"))
        val urlBytes = KNetUtil.getUrlBytes("https://www.baidu.com")
        val byteStr = urlBytes.joinToString(separator = " ")
        print(byteStr)
        val f = File("百度一下.html")
        f.writeBytes(urlBytes)
        KNetUtil.writeUrlBytesTo("图片.jpg",
                "http://n.sinaimg.cn/default/4_img/uplaod/3933d981/20170622/2fIE-fyhfxph6601959.jpg")
    }

}
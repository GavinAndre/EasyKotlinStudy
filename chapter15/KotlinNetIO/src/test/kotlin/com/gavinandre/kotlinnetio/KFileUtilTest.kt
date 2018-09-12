package com.gavinandre.kotlinnetio

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class KFileUtilTest {

    val filename = "唐诗三百首.txt"

    @Test
    fun testGetFileContent() {
        val content = KFileUtil.getFileContent(filename)
        println(content)
    }

    @Test
    fun getFileLines() {
        val lines = KFileUtil.getFileLines(filename)

        lines.forEach {
            println(it)
        }

        println("文件行数：${lines.size}")
    }

    @Test
    fun getFileBytes() {
        val bytes = KFileUtil.getFileBytes(filename)
        bytes.forEach {
            print("${it} ")
        }
    }

    @Test
    fun writeFile() {
        val srcContent = KFileUtil.getFileContent(filename)
        KFileUtil.writeFile(srcContent, destFile = "唐诗.txt")
    }

    @Test
    fun appendFile() {
        val srcContent = KFileUtil.getFileContent(filename)
        KFileUtil.appendFile(srcContent, destFile = "唐诗.txt")
    }

    @Test
    fun getFileContent() {
        val content = KFileUtil.getFileContent(filename)
        println(content)
    }

    @Test
    fun traverseFileTree() {
        KFileUtil.traverseFileTree(".")
    }

    @Test
    fun getFileSequenceBy() {
        val fileSequence1 = KFileUtil.getFileSequenceBy(".") {
            it.isDirectory
        }
        fileSequence1.forEach {
            println("fileSequence1: ${it.absoluteFile}")
        }

        val fileSequence2 = KFileUtil.getFileSequenceBy(".") {
            it.isFile
        }
        fileSequence2.forEach {
            println("fileSequence2: ${it.absoluteFile}")
        }

        val fileSequence3 = KFileUtil.getFileSequenceBy(".") {
            it.extension == "kt"
        }
        fileSequence3.forEach {
            println("fileSequence3: ${it.absoluteFile}")
        }
    }
}
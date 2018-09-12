package com.gavinandre.kotlinnetio

import java.io.File
import java.nio.charset.Charset

object KFileUtil {

    /**
     * 获取文件全部内容字符串
     */
    fun getFileContent(filename: String): String {
        val f = File(filename)
        return f.readText(Charset.forName("UTF-8"))
    }

    /**
     * 获取文件每一行内容,存入一个List中
     */
    fun getFileLines(filename: String): List<String> {
        return File(filename).readLines(Charset.forName("UTF-8"))
    }

    /**
     * 获取文件比特流数组
     */
    fun getFileBytes(filename: String): ByteArray {
        val f = File(filename)
        return f.readBytes()
    }

    /**
     * 覆盖写文件
     */
    fun writeFile(text: String, destFile: String) {
        val f = File(destFile)
        if (!f.exists()) {
            f.createNewFile()
        }
        f.writeText(text, Charset.defaultCharset())
    }

    /**
     * 末尾追加写文件
     */
    fun appendFile(text: String, destFile: String) {
        val f = File(destFile)
        if (!f.exists()) {
            f.createNewFile()
        }
        f.appendText(text, Charset.defaultCharset())
    }

    /**
     * 首行插入写文件
     */
    fun headInsertFile(text: String, destFile: String) {
        val f = File(destFile)
        if (!f.exists()) {
            f.createNewFile()
        }
        val lines = getFileLines(destFile)
        val newLines = ArrayList<String>(lines.size + 1)
        newLines.add(text)
        lines.forEach {
            newLines.add(it)
        }

        val newText = newLines.joinToString(separator = "\n") { it }
        f.writeText(newText, Charset.defaultCharset())
    }

    /**
     * 遍历指定文件夹下的所有文件
     */
    fun traverseFileTree(filename: String) {
        val f = File(filename)
        val fileTreeWalk = f.walk()
        fileTreeWalk.iterator().forEach { println(it.absolutePath) }
    }

    /**
     * 遍历当前文件下面所有子目录文件，存入一个 Iterator<File> 中
     */
    fun getFileIterator(filename: String): Iterator<File> {
        val f = File(filename)
        val fileTreeWalk = f.walk()
        return fileTreeWalk.iterator()
    }

    /**
     * 遍历当前文件下面所有子目录文件，根据过滤条件过滤，并把结果存入一个 Sequence<File> 中
     */
    fun getFileSequenceBy(filename: String, p: (File) -> Boolean): Sequence<File> {
        val f = File(filename)
        return f.walk().filter(p)
    }

}
package com.gavinandre.kotlinnetio

import com.gavinandre.kotlinnetio.KFileUtil.getFileContent
import java.util.*
import java.util.regex.Pattern

object KCountUtil {

    fun countSummary(filename: String): Map<String, Int> {
        val content = getFileContent(filename)
        val countNumber = countNumber(content)
        val countLetter = countLetter(content)
        val countWord = countWord(content)
        val countSpace = countSpace(content)
        var map = hashMapOf<String, Int>()
        map.put("countNumber", countNumber)
        map.put("countLetter", countLetter)
        map.put("countWord", countWord)
        map.put("countSpace", countSpace)
        return map
    }

    /**
     * 统计数字数
     * @param str
     * *
     * @return
     */
    fun countNumber(str: String): Int {
        var count = 0
        val p = Pattern.compile("\\d")
        val m = p.matcher(str)
        while (m.find()) {
            count++
        }
        return count
    }

    /**
     * 统计字母数
     * @param str
     * *
     * @return
     */
    fun countLetter(str: String): Int {
        var count = 0
        val p = Pattern.compile("[a-zA-Z]")
        val m = p.matcher(str)
        while (m.find()) {
            count++
        }
        return count
    }

    /**
     * 统计英文单词数
     * @param str
     * *
     * @return
     */
    fun countWord(str: String): Int {
        var count = 0
        val p = Pattern.compile("\\w")
        val m = p.matcher(str)
        while (m.find()) {
            count++
        }
        return count
    }

    /**
     * 统计汉字数
     * @param str
     * *
     * @return
     */
    fun countChineseCharacters(filename: String): List<MutableMap.MutableEntry<String, Int>> {
        return countChineseWordFreq(filename, 1)
    }

    /**
     * 统计英文词频
     * @param filename 数据文件名
     * @wordsNum 表示几个词
     *
     * @return
     */
    fun countEnglishWordFreq(filename: String, wordsNum: Int): List<MutableMap.MutableEntry<String, Int>> {
        val str = getFileContent(filename)
        // \b[\w+]+\b\s
        var englishWordRegex = ""
        for (i in 1..wordsNum) {
            englishWordRegex += "\\b[\\w+]+\\b\\s"
        }
        return doWordCount(englishWordRegex, str)
    }

    /**
     * 统计汉字词频
     * @param filename 数据文件名
     * @wordsNum 表示几个字的词
     *
     * @return
     */
    fun countChineseWordFreq(filename: String, wordsNum: Int): List<MutableMap.MutableEntry<String, Int>> {
        val str = getFileContent(filename)
        val wordRegex = "$[\\u4e00-\\u9fa5]{${wordsNum}}"
        return doWordCount(wordRegex, str)
    }

    private fun doWordCount(wordRegex: String, str: String): List<MutableMap.MutableEntry<String, Int>> {
        val p = Pattern.compile(wordRegex)
        val m = p.matcher(str)
        var startIndex = 0
        val map = hashMapOf<String, Int>()
        while (m.find(startIndex)) {
            startIndex = m.start()
            var endIndex = m.end()
            val word = str.substring(startIndex, endIndex)
            if (!map.containsKey(word)) {
                map.put(word, 1)
            } else {
                map[word]?.let { map.put(word, it + 1) }
            }
            startIndex++
        }

        // 根据 key 排序
        val entrySetList = ArrayList(map.entries)
        Collections.sort(entrySetList, { e1, e2 ->
            e2.value.compareTo(e1.value)
        })

        return entrySetList
    }

    /**
     * 统计空格数
     * @param str
     * *
     * @return
     */
    fun countSpace(str: String): Int {
        var count = 0
        val p = Pattern.compile("\\s")
        val m = p.matcher(str)
        while (m.find()) {
            count++
        }
        return count
    }

}

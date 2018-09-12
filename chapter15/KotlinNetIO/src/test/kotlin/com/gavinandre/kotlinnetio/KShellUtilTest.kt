package com.gavinandre.kotlinnetio

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class KShellUtilTest {

    @Test
    fun test() {
        val p = "ls -al".execute()

        val exitCode = p.waitFor()
        val text = p.text()

        println(exitCode)
        println(text)
    }

}
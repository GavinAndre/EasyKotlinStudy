package com.gavinandre.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ExtensionsDemoTest {

    @Test
    fun testExtensions() {
        val extensionsDemo = ExtensionsDemo()
        extensionsDemo.useExtensions()

        val extensionsInnerDemo = ExtensionsDemo.Inner()
        extensionsInnerDemo.useExtensions()

    }

}
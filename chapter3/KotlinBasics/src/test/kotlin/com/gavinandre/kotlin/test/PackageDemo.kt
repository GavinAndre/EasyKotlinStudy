package com.gavinandre.kotlin.test

import com.gavinandre.kotlin.Motorbike
import com.gavinandre.kotlin.what
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PackageDemoTest{

    @Test
    fun testWhat(){
        what()
    }

    @Test
    fun testDriveMotorbike(){
        val motorbike = Motorbike()
        motorbike.drive()
    }
}
package com.gavinandre.kotlininteroperatewithjava

class CheckKotlinException {

    fun thisIsAFunWithException() {
        throw Exception("I am an exception in kotlin")
    }

    /**
     * 加上Throws注解可以使Java调用时提示捕捉这个异常
     */
    @Throws(Exception::class)
    fun thisIsAnotherFunWithException() {
        throw Exception("I am Another exception in kotlin")
    }
}
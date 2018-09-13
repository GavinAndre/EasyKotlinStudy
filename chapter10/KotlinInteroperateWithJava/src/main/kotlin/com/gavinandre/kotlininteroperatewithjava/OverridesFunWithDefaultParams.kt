package com.gavinandre.kotlininteroperatewithjava

class OverridesFunWithDefaultParams {
    fun f1(a: Int = 0, b: String = "B") {

    }

    /**
     * @JvmOverloads 编译器会处理这个注解所标注的函数，并为之生成额外的重载函数给Java调用
     */
    @JvmOverloads
    fun f2(a: Int = 0, b: String = "B") {

    }
}
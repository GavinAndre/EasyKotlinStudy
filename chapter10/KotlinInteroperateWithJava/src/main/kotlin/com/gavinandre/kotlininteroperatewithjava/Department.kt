package com.gavinandre.kotlininteroperatewithjava

class Department {
    var id: Long = -1L
    var name: String = "Dept"
    var isOpen: Boolean = true
    var isBig: String = "Y"

    /**
     * @JvmField 注解对Kotlin中的属性字段标注，表示这是一个实例字段（Instance Fields），
     * Kotlin编译器在处理的时候，将不会给这个字段生成getters/setters方法
     */
    @JvmField
    var NO = 0

    /**
     * Kotlin中在命名对象或伴生对象中声明的属性
     * 这个私有的innerID通过Companion对象来封装，提供出public的getInnerID() 、setInnerID来访问
     */
    companion object {
        //innerID会被编译为private static String innerID
        var innerID = "X001"
        //innerName会被编译为public static String innerID
        @JvmField
        var innerName = "DEP"

        fun getObjectName() = "ONAME"

        //@JvmStatic注解,编译器既会在相应对象的类中生成静态方法，也会在对象自身中生成实例方法
        @JvmStatic
        fun getObjectID() = "OID"
    }
}
package com.gavinandre.kotlinoop

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class NormalPropertiesDemo {
    var content: String = "NormalProperties init content"
}

class DelegatePropertiesDemo {
    /**
     * 将content委托给Content对象
     * content属性对应的 get()和 set()会被委托给Content()的 operator fun getValue() 和 operator fun setValue() 函数
     * 这两个函数是必须的，而且得是操作符函数
     */
    var content: String by Content()

    override fun toString(): String {
        return "DelegatePropertiesDemo Class"
    }
}

class Content {
    operator fun getValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>): String {
        return "${delegatePropertiesDemo} property '${property.name}' = 'Balalala ... ' "
    }

    operator fun setValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>, value: String) {
        println("${delegatePropertiesDemo} property '${property.name}' is setting value: '$value'")
    }
}

/**
 * Delegates.observable 可观察属性委托
 */
class PostHierarchy {

    var level: String by Delegates.observable("P0")
    { property: KProperty<*>, oldValue: String, newValue: String ->
        //当属性值被重新赋值的时候， 触发Delegates.observable的回调函数 onChange
        println("$oldValue->$newValue")
    }

    var grade: String by Delegates.vetoable("T0")
    { property, oldValue, newValue ->
        true
    }

    var notChangeGrade: String by Delegates.vetoable("T0")
    { property, oldValue, newValue ->
        false
    }

    var name: String by Delegates.notNull()
}

/**
 * 属性委托给Map映射
 */
class Account(val map: Map<String, Any?>) {
    val name: String by map
    val password: String by map
}

class MutableAccount(val map: MutableMap<String, Any?>) {
    var name: String by map
    var password: String by map
}


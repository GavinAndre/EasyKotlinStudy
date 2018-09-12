package com.gavinanere.kotlinfop

import javax.swing.tree.TreeNode

class FPApi {

    fun closureDemo() {
        Thread {
            for (i in 1..10) {
                println("I = $i")
                Thread.sleep(1000)
            }
        }.start()

        Thread {
            for (j in 10..20) {
                println("J = $j")
                Thread.sleep(2000)
            }
            Thread.sleep(1000)
        }.start()
    }

    fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
        var p = parent
        while (p != null && !clazz.isInstance(p)) {
            p = p.parent
        }
        @Suppress("UNCHECKED_CAST")
        return p as T?
    }

}

/**
 * 具体化的类型参数
 */
inline fun <reified T> membersOf() = T::class.members

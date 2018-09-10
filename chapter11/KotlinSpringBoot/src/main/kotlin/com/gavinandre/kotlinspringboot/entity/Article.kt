package com.gavinandre.kotlinspringboot.entity

import java.util.*
import javax.persistence.*

@Entity
class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    @Version
    var version: Long = 0
    var title: String = ""
    var content: String = ""
    var author: String = ""
    var gmtCreated: Date = Date()
    var gmtModified: Date = Date()
    //1 Yes 0 No
    var isDeleted: Int = 0
    var deletedDate: Date = Date()

    override fun toString(): String {
        return "Article(id=$id, version=$version, title='$title', content='$content', author='$author', " +
                "gmtCreated=$gmtCreated, gmtModified=$gmtModified, isDeleted=$isDeleted, deletedDate=$deletedDate)"
    }

}
package com.gavinandre.kotlinspringboot.dao

import com.gavinandre.kotlinspringboot.entity.Article
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

/**
@Query注解里面的value和nativeQuery=true,意思是使用原生的sql查询语句.
sql模糊查询like语法,我们在写sql的时候是这样写的
like '%?%'
但是在@Query的value字符串中, 这样写
like %?1%
 */
interface ArticleRepository : CrudRepository<Article, Long> {

    @Query("select a from #{#entityName} a order by a.gmtCreated desc")
    override fun findAll(): MutableList<Article>

    @Query(value = "Select * from blog.article where title like %?1%", nativeQuery = true)
    fun findByTitle(title: String): MutableList<Article>

    @Query("SELECT a FROM #{#entityName} a where a.content like %:content%")
    fun findByContent(@Param("content") content: String): MutableList<Article>

    @Query(value = "select * from blog.article where author = ?1", nativeQuery = true)
    fun findByAuthor(author: String): MutableList<Article>
}
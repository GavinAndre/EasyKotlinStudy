package com.gavinandre.kotlinspringboot

import com.gavinandre.kotlinspringboot.dao.ArticleRepository
import com.gavinandre.kotlinspringboot.entity.Article
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class KotlinSpringBootApplication {
    @Bean
    fun init(repository: ArticleRepository) = CommandLineRunner {
        val article = Article()
        article.author = "Kotlin"
        article.title = "极简Kotlin教程 ${Date()}"
        article.content = "Easy Kotlin ${Date()}"
        repository.save(article)
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinSpringBootApplication>(*args)
}

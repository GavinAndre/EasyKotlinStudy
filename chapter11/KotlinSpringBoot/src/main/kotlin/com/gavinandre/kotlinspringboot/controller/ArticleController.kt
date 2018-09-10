package com.gavinandre.kotlinspringboot.controller

import com.gavinandre.kotlinspringboot.dao.ArticleRepository
import com.gavinandre.kotlinspringboot.entity.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import java.util.*

@Controller
class ArticleController {

    @Autowired
    val articleRepository: ArticleRepository? = null

    @GetMapping("listAllArticle")
    @ResponseBody
    fun listAllArticle(): MutableList<Article>? {
        return articleRepository?.findAll()
    }

    @GetMapping("listAllArticleView")
    fun listAllArticleView(model: Model): ModelAndView {
        model.addAttribute("articles", articleRepository?.findAll())
        return ModelAndView("listAllArticleView")
    }

    @PostMapping("saveArticle")
    @ResponseBody
    fun saveArticle(article: Article): Article? {
        article.gmtCreated = Date()
        article.gmtModified = Date()
        article.version = 0
        return articleRepository?.save(article)
    }

    @GetMapping("detailArticleView")
    fun detailArticleView(id: Long, model: Model): ModelAndView {
        model.addAttribute("article", articleRepository?.findById(id)?.get())
        return ModelAndView("detailArticleView")
    }

}
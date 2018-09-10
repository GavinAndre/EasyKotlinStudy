package com.gavinandre.kotlinoop

class Project

class Milestone

interface ProjectService {
    val name: String
    val owner: String
    fun save(project: Project)
    fun print() {
        println(" i am project")
    }
}

interface MilestoneService {
    val name: String //抽象的
    val owner: String
        get() = "Andre" //访问器

    fun save(milestone: Milestone)
    fun print() {
        println("i am milestone")
    }
}

class MilestoneServiceImpl : MilestoneService {
    override val name: String
        get() = "MilestoneServiceImpl name"

    override fun save(milestone: Milestone) {
        println("save milestone")
    }
}

/**
 * 使用冒号: 语法来实现一个接口，如果有多个用，逗号隔开
 */
class ProjectMilestoneServiceImpl : ProjectService, MilestoneService {
    override val name: String
        get() = "ProjectMilestone"
    override val owner: String
        get() = "GavinAndre"

    override fun save(project: Project) {
        println("save project")
    }

    override fun print() {
//        super.print() //覆盖冲突
        super<ProjectService>.print()
        super<MilestoneService>.print()
    }

    override fun save(milestone: Milestone) {
        println("save milestone")
    }
}
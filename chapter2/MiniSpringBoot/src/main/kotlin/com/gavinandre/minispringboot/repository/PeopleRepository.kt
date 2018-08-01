package com.gavinandre.minispringboot.repository

import com.gavinandre.minispringboot.entity.People
import org.springframework.data.repository.CrudRepository

interface PeopleRepository : CrudRepository<People, Long> {
    fun findByLastName(lastName: String): List<People>?
}
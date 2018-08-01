package com.gavinandre.minispringboot.service

import com.gavinandre.minispringboot.entity.People
import com.gavinandre.minispringboot.repository.PeopleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PeopleService : PeopleRepository {

    @Autowired
    val peopleRepository: PeopleRepository? = null

    override fun findByLastName(lastName: String): List<People> {
        return peopleRepository?.findByLastName(lastName)!!
    }

    override fun <S : People?> save(entity: S): S {
        return peopleRepository?.save(entity)!!
    }

    override fun findAll(): MutableIterable<People> {
        return peopleRepository?.findAll()!!
    }

    override fun deleteById(id: Long) {
        return peopleRepository?.deleteById(id)!!
    }

    override fun deleteAll(entities: MutableIterable<People>) {
        return peopleRepository?.deleteAll(entities)!!
    }

    override fun deleteAll() {
        return peopleRepository?.deleteAll()!!
    }

    override fun <S : People?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        return peopleRepository?.saveAll(entities)!!
    }

    override fun count(): Long {
        return peopleRepository?.count()!!
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableIterable<People> {
        return peopleRepository?.findAllById(ids)!!
    }

    override fun existsById(id: Long): Boolean {
        return peopleRepository?.existsById(id)!!
    }

    override fun findById(id: Long): Optional<People> {
        return peopleRepository?.findById(id)!!
    }

    override fun delete(entity: People) {
        return peopleRepository?.delete(entity)!!
    }
}
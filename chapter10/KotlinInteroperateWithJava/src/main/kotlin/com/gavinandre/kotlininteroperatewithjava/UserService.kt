package com.gavinandre.kotlininteroperatewithjava

interface UserService {
    fun findByName(name: String): User
}
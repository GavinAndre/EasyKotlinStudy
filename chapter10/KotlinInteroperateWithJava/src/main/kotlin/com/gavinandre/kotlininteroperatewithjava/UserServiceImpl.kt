package com.gavinandre.kotlininteroperatewithjava

class UserServiceImpl : UserService{
    override fun findByName(name: String): User {
        return User("admin","admin")
    }

}
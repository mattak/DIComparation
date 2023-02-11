package me.mattak.dicomparation.domain.repository

import me.mattak.dicomparation.domain.entity.User
import javax.inject.Inject

interface UserRepository {
    fun findUser(name: String): User?
    fun addUsers(users: List<User>)
}

class UserRepositoryImpl @Inject constructor() : UserRepository {
    private val _users = arrayListOf<User>()

    override fun findUser(name: String): User? {
        return _users.firstOrNull { it.name == name }
    }

    override fun addUsers(users: List<User>) {
        _users.addAll(users)
    }
}

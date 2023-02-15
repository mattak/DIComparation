package me.mattak.dicomparation.domain.usecase

import me.mattak.dicomparation.domain.repository.UserRepository
import javax.inject.Inject

interface HelloUseCase {
    fun execute(name: String): String
}

class HelloUseCaseImpl @Inject constructor(
    private val repository: UserRepository
) : HelloUseCase {
    override fun execute(name: String): String {
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello, '${it.name}' from $this" } ?: "User '$name' not found!"
    }
}

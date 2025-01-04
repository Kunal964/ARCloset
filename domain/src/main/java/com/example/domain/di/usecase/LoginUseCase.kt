package com.example.domain.di.usecase

import com.example.domain.di.repo.UserRepository

class LoginUseCase(private val userRepository: UserRepository) {
    suspend fun execute(email: String, password: String) = userRepository.login(email, password)

}
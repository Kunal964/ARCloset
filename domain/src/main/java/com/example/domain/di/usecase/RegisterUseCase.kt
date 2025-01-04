package com.example.domain.di.usecase

import com.example.domain.di.repo.UserRepository

class RegisterUseCase(private val userRepository: UserRepository) {
    suspend fun execute(email: String, password: String, name: String) = userRepository.register(email, password, name)
}
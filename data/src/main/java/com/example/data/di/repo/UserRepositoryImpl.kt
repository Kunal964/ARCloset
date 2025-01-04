package com.example.data.di.repo

import com.example.domain.di.network.NetworkService
import com.example.domain.di.repo.UserRepository

class UserRepositoryImpl(private val networkService: NetworkService) : UserRepository {
    override suspend fun login(email: String, password: String) = networkService.login(email, password)
    override suspend fun register(email: String, password: String, name: String) = networkService.register(email, password, name)
}
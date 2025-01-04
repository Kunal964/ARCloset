package com.example.domain.di.repo

import com.example.domain.di.model.UserDomainModel
import com.example.domain.di.network.ResultWrapper

interface UserRepository {
    suspend fun login(email: String, password: String): ResultWrapper<UserDomainModel>
    suspend fun register(email: String, password: String, name: String): ResultWrapper<UserDomainModel>
}
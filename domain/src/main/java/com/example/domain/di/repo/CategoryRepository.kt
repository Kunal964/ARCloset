package com.example.domain.di.repo

import com.example.domain.di.network.ResultWrapper

interface CategoryRepository {
    suspend fun getCategories(): ResultWrapper<List<String>>
}
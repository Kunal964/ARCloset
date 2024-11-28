package com.example.data.di.repo

import com.example.domain.di.network.NetworkService
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.repo.CategoryRepository

class CategoryRepositoryImpl(val networkService: NetworkService): CategoryRepository {
    override suspend fun getCategories(): ResultWrapper<List<String>> {
        return networkService.getCategories()
    }
}
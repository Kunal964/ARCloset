package com.example.domain.di.usecase

import com.example.domain.di.repo.CategoryRepository

class GetCategoryUseCase(private val repository: CategoryRepository) {
    suspend fun execute() = repository.getCategories()
}
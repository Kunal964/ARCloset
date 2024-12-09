package com.example.domain.di.usecase

import com.example.domain.di.repo.ProductRepository

class GetProductUseCase(private val repo: ProductRepository) {
    suspend fun execute(category: Int?) = repo.getProducts(category)
}
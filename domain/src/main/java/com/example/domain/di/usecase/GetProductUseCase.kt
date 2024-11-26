package com.example.domain.di.usecase

import com.example.domain.di.repo.ProductRepo

class GetProductUseCase(private val repo: ProductRepo) {
    suspend fun execute(category: String?) = repo.getProducts(category)
}
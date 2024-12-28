package com.example.domain.di.usecase

import com.example.domain.di.repo.CartRepository

class CartSummaryUseCase (private val repository: CartRepository) {
    suspend fun execute(userId: Long) = repository.getCartSummary(userId)
}
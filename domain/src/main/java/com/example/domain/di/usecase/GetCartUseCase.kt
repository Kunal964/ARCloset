package com.example.domain.di.usecase

import com.example.domain.di.repo.CartRepository

class GetCartUseCase(val cartRepository: CartRepository) {
    suspend fun execute() = cartRepository.getCart()

}
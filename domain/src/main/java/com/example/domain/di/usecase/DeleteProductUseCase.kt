package com.example.domain.di.usecase

import com.example.domain.di.model.CartItemModel
import com.example.domain.di.repo.CartRepository

class DeleteProductUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(cartItemId: Int, userId: Int) = cartRepository.deleteItem(cartItemId, userId)

}


package com.example.domain.di.usecase

import com.example.domain.di.model.CartItemModel
import com.example.domain.di.repo.CartRepository

class UpdateQuantityUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(cartItemModel: CartItemModel,userId: Long) = cartRepository.updateQuantity(cartItemModel, userId)

}


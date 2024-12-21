package com.example.domain.di.usecase


import com.example.domain.di.model.request.AddCartRequestModel
import com.example.domain.di.repo.CartRepository

class AddToCartUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(request: AddCartRequestModel) = cartRepository.addProductToCart(request)
}
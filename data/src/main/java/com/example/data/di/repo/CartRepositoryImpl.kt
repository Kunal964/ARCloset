package com.example.data.di.repo

import com.example.domain.di.model.CartItemModel
import com.example.domain.di.model.CartModel
import com.example.domain.di.model.CartSummary
import com.example.domain.di.model.request.AddCartRequestModel
import com.example.domain.di.network.NetworkService
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.repo.CartRepository

class CartRepositoryImpl(val networkService: NetworkService) : CartRepository {
    override suspend fun addProductToCart(request: AddCartRequestModel,userId: Long): ResultWrapper<CartModel> {
        return networkService.addProductToCart(request,userId)
    }

    override suspend fun getCart(userId: Long): ResultWrapper<CartModel> {
        return networkService.getCart(userId)
    }

    override suspend fun updateQuantity(cartItemModel: CartItemModel,userId: Long): ResultWrapper<CartModel> {
        return networkService.updateQuantity(cartItemModel, userId)
    }

    override suspend fun deleteItem(cartItemId: Int, userId: Long): ResultWrapper<CartModel> {
        return networkService.deleteItem(cartItemId, userId)
    }

    override suspend fun getCartSummary(userId: Long): ResultWrapper<CartSummary> {
        return networkService.getCartSummary(userId)
    }
}
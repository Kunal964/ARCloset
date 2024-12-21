package com.example.data.di.repo

import com.example.domain.di.model.CartModel
import com.example.domain.di.model.request.AddCartRequestModel
import com.example.domain.di.network.NetworkService
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.repo.CartRepository

class CartRepositoryImpl(val networkService: NetworkService) : CartRepository {
    override suspend fun addProductToCart(request: AddCartRequestModel): ResultWrapper<CartModel> {
        return networkService.addProductToCart(request)
    }

    override suspend fun getCart(): ResultWrapper<CartModel> {
        return networkService.getCart()
    }
}
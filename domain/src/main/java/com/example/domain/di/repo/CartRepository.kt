package com.example.domain.di.repo

import com.example.domain.di.model.CartItemModel
import com.example.domain.di.model.CartModel
import com.example.domain.di.model.CartSummary
import com.example.domain.di.model.request.AddCartRequestModel
import com.example.domain.di.network.ResultWrapper

interface CartRepository {

    suspend fun addProductToCart(request: AddCartRequestModel, userId: Long): ResultWrapper<CartModel>
    suspend fun getCart(userId: Long): ResultWrapper<CartModel>
    suspend fun updateQuantity(cartItemModel: CartItemModel,userId: Long) : ResultWrapper<CartModel>
    suspend fun deleteItem(cartItemId: Int, userId: Long): ResultWrapper<CartModel>
    suspend fun getCartSummary(userId: Long): ResultWrapper<CartSummary>

}
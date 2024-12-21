package com.example.domain.di.model

data class CartItemModel(
    val id: Int,
    val productId: Int,
    val price: Double,
    val quantity: Int,
    val productName: String,
    val imageUrl: String? = null,
)

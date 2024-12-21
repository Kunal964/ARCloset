package com.example.domain.di.model.request

data class AddCartRequestModel(
    val productId: Int,
    val productName: String,
    val price: Double,
    val userId: Int,
    val quantity: Int

)

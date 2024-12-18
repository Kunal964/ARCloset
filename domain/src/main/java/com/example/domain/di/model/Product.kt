package com.example.domain.di.model

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val categoryId: Int,
    val description: String,
    val image: String,
){
    val priceString: String
        get() = "$$price"

}
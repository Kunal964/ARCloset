package com.example.domain.di.model

data class Product(
    val id: Long,
    val title: String,
    val price: Double,
    val category: String,
    val description: String,
    val Image: String,
){
    val priceString: String
        get() = "$$price"
}
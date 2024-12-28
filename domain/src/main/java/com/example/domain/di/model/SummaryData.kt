package com.example.domain.di.model

data class SummaryData(
    val discount: Double,
    val items: List<CartItemModel>,
    val shipping: Double,
    val subtotal: Double,
    val tax: Double,
    val total: Double
)

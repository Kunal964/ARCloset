package com.example.data.di.model

import kotlinx.serialization.Serializable



@Serializable
class DataProductModel (
    val categoryId: Int,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
){
    fun toProduct()  = com.example.domain.di.model.Product(
        id = id,
        title = title,
        price = price,
        categoryId = categoryId,
        description = description,
        image = image
    )
    }

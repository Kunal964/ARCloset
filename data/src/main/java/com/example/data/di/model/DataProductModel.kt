package com.example.data.di.model

import kotlinx.serialization.Serializable



@Serializable
class DataProductModel (
    val id: Long,
    val title: String,
    val price: Double,
    val category: String,
    val description: String,
    val Image: String? = null
){
    fun toProduct()  = com.example.domain.di.model.Product(
        id = id,
        title = title,
        price = price,
        category = category,
        description = description,
        Image = Image?: ""
    )
    }

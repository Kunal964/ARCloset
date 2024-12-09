package com.example.data.di.model

import kotlinx.serialization.Serializable


@Serializable
data class CategoyDataModel(
    val id: Int,
    val image: String,
    val title: String
)
{
    fun toCategory() = com.example.domain.di.model.Category(
        id = id,
        image = image,
        title = title
    )
}
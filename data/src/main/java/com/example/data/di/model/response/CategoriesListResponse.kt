package com.example.data.di.model.response

import com.example.data.di.model.CategoyDataModel
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesListResponse(
    val `data`: List<CategoyDataModel>,
    val msg: String
)
{
    fun toCategoriesList() = com.example.domain.di.model.CategoriesListModel(
        categories = `data`.map { it.toCategory() },
        msg = msg
    )
}
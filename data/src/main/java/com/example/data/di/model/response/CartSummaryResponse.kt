package com.example.data.di.model.response

import com.example.data.di.model.Summary
import kotlinx.serialization.Serializable

@Serializable
data class CartSummaryResponse(
    val `data`: Summary,
    val msg: String,
){
    fun toCartSummary() = com.example.domain.di.model.CartSummary(
        data = `data`.toSummaryData(),
        msg = msg
    )
}
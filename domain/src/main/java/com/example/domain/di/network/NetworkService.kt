package com.example.domain.di.network

import com.example.domain.di.model.Product

interface NetworkService {
    suspend fun getProducts(): ResultWrapper<List<Product>>
}

sealed class ResultWrapper<out T> {
    data class Success<out T>(val valur: T) : ResultWrapper<T>()
    data class Failure(val exception: Exception) : ResultWrapper<Nothing>()
}
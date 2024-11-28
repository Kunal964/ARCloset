package com.example.domain.di.repo

import com.example.domain.di.model.Product
import com.example.domain.di.network.ResultWrapper

interface ProductRepository {
   suspend fun getProducts(category: String?): ResultWrapper<List<Product>>
}
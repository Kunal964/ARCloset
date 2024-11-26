package com.example.data.di.repo

import com.example.domain.di.model.Product
import com.example.domain.di.network.NetworkService
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.repo.ProductRepo

class ProductRepoImpl(private val networkService: NetworkService) : ProductRepo {
    override suspend fun getProducts(category: String?): ResultWrapper<List<Product>> {
        return networkService.getProducts(category)
    }
}
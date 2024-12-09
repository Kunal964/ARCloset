package com.example.data.di.repo

import com.example.domain.di.model.Product
import com.example.domain.di.model.ProductListModel
import com.example.domain.di.network.NetworkService
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.repo.ProductRepository

class ProductRepositoryImpl(private val networkService: NetworkService) : ProductRepository {
    override suspend fun getProducts(category: Int?): ResultWrapper<ProductListModel> {
        return networkService.getProducts(category)
    }
}
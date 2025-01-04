package com.example.data.di.repo

import com.example.domain.di.model.AddressDomainModel
import com.example.domain.di.model.OrdersListModel
import com.example.domain.di.network.NetworkService
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.repo.OrderRepository

class OrderRepositoryImpl(private val networkService: NetworkService) : OrderRepository {
    override suspend fun placeOrder(addressDomainModel: AddressDomainModel, userId: Long): ResultWrapper<Long> {
        return networkService.placeOrder(addressDomainModel, userId)
    }

    override suspend fun getOrderList(userId: Long): ResultWrapper<OrdersListModel> {
        return networkService.getOrderList(userId)
    }
}
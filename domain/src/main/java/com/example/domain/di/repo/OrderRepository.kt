package com.example.domain.di.repo

import com.example.domain.di.model.AddressDomainModel
import com.example.domain.di.model.OrdersListModel
import com.example.domain.di.network.ResultWrapper

interface OrderRepository {
    suspend fun placeOrder(addressDomainModel: AddressDomainModel,userId: Long): ResultWrapper<Long>
    suspend fun getOrderList(userId: Long): ResultWrapper<OrdersListModel>
}
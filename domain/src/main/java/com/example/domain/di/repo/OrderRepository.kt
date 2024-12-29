package com.example.domain.di.repo

import com.example.domain.di.model.AddressDomainModel
import com.example.domain.di.network.ResultWrapper

interface OrderRepository {
    suspend fun placeOrder(addressDomainModel: AddressDomainModel): ResultWrapper<Long>
}
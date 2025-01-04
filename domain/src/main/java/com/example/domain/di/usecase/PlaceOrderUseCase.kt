package com.example.domain.di.usecase

import com.example.domain.di.model.AddressDomainModel
import com.example.domain.di.repo.OrderRepository

class PlaceOrderUseCase(val orderRepository: OrderRepository) {
    suspend fun execute(addressDomainModel: AddressDomainModel,userId: Long) = orderRepository.placeOrder(addressDomainModel, userId)
}
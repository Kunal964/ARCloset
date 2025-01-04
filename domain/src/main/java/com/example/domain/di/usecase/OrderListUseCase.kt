package com.example.domain.di.usecase

import com.example.domain.di.repo.OrderRepository

class OrderListUseCase(
    private val repository: OrderRepository
) {
    suspend fun execute(userId: Long) = repository.getOrderList(userId)
}
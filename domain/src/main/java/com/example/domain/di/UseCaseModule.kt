package com.example.domain.di

import com.example.domain.di.usecase.AddToCartUseCase
import com.example.domain.di.usecase.CartSummaryUseCase
import com.example.domain.di.usecase.DeleteProductUseCase
import com.example.domain.di.usecase.GetCartUseCase
import com.example.domain.di.usecase.GetCategoryUseCase
import com.example.domain.di.usecase.GetProductUseCase
import com.example.domain.di.usecase.PlaceOrderUseCase
import com.example.domain.di.usecase.UpdateQuantityUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetProductUseCase(get()) }
    factory { GetCategoryUseCase(get()) }
    factory { AddToCartUseCase(get()) }
    factory { GetCartUseCase(get()) }
    factory { UpdateQuantityUseCase(get()) }
    factory { DeleteProductUseCase(get()) }
    factory { CartSummaryUseCase(get()) }
    factory { PlaceOrderUseCase(get()) }
}
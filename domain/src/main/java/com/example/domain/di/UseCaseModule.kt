package com.example.domain.di

import com.example.domain.di.usecase.AddToCartUseCase
import com.example.domain.di.usecase.GetCartUseCase
import com.example.domain.di.usecase.GetCategoryUseCase
import com.example.domain.di.usecase.GetProductUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetProductUseCase(get()) }
    factory { GetCategoryUseCase(get()) }
    factory { AddToCartUseCase(get()) }
    factory { GetCartUseCase(get()) }
}
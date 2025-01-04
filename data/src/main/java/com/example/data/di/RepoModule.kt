package com.example.data.di

import com.example.data.di.repo.CartRepositoryImpl
import com.example.data.di.repo.CategoryRepositoryImpl
import com.example.data.di.repo.OrderRepositoryImpl
import com.example.data.di.repo.ProductRepositoryImpl
import com.example.data.di.repo.UserRepositoryImpl
import com.example.domain.di.repo.CartRepository
import com.example.domain.di.repo.CategoryRepository
import com.example.domain.di.repo.OrderRepository
import com.example.domain.di.repo.ProductRepository
import com.example.domain.di.repo.UserRepository
import org.koin.dsl.module

val repoModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get())}
    single<CategoryRepository> {CategoryRepositoryImpl(get())}
    single<CartRepository> { CartRepositoryImpl(get()) }
    single<OrderRepository> { OrderRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}

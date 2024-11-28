package com.example.data.di

import com.example.data.di.repo.CategoryRepositoryImpl
import com.example.data.di.repo.ProductRepositoryImpl
import com.example.domain.di.repo.CategoryRepository
import com.example.domain.di.repo.ProductRepository
import org.koin.dsl.module

val repoModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get())}
    single<CategoryRepository> {CategoryRepositoryImpl(get())}

}
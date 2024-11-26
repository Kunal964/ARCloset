package com.example.data.di

import com.example.data.di.repo.ProductRepoImpl
import com.example.domain.di.model.Product
import com.example.domain.di.repo.ProductRepo
import org.koin.dsl.module

val repoModule = module {
    single<ProductRepo> { ProductRepoImpl(get())}

}
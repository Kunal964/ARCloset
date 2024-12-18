package com.example.ecommercerugsandtees.di

import com.example.ecommercerugsandtees.ui.theme.feature.product_details.ProductDetailsViewModel
import com.example.ecommercerugsandtees.ui.theme.feature.screens.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        HomeViewModel(get(), get())
    }
    viewModel {
        ProductDetailsViewModel()
    }
}
package com.example.ecommercerugsandtees.di

import com.example.ecommercerugsandtees.screens.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        HomeViewModel(get())
    }
}
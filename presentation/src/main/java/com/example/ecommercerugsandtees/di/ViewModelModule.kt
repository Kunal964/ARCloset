package com.example.ecommercerugsandtees.di

import com.example.ecommercerugsandtees.ui.theme.feature.account.login.LoginViewModel
import com.example.ecommercerugsandtees.ui.theme.feature.account.register.RegisterViewModel
import com.example.ecommercerugsandtees.ui.theme.feature.cart.CartViewModel
import com.example.ecommercerugsandtees.ui.theme.feature.orders.OrdersViewModel
import com.example.ecommercerugsandtees.ui.theme.feature.product_details.ProductDetailsViewModel
import com.example.ecommercerugsandtees.ui.theme.feature.screens.HomeViewModel
import com.example.ecommercerugsandtees.ui.theme.feature.summary.CartSummaryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(get(), get())
    }
    viewModel {
        ProductDetailsViewModel(get(),get())
    }
    viewModel {
        CartViewModel(get(), get(), get(),get())
    }
    viewModel {
        CartSummaryViewModel(get(), get(),get())
    }
    viewModel {
        OrdersViewModel(get(),get())
    }

    viewModel {
        LoginViewModel(get(),get())
    }

    viewModel {
        RegisterViewModel(get(),get())
    }
}
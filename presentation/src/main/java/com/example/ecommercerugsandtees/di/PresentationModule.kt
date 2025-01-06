package com.example.ecommercerugsandtees.di

import com.example.ecommercerugsandtees.ShopperSession
import org.koin.dsl.module

val presentationmodule = module {
    includes(viewModelModule)
    single { ShopperSession(get()) }

}
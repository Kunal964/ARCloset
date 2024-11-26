package com.example.ecommercerugsandtees.di

import org.koin.dsl.module

val presentationmodule = module {
    includes(viewModelModule)

}
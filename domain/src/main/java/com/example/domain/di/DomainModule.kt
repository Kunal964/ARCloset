package com.example.domain.di

import org.koin.dsl.module

val domainmodule = module {
    includes(useCaseModule)
}
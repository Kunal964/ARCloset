package com.example.ecommercerugsandtees

import android.app.Application
import com.example.data.di.datamodule
import com.example.domain.di.domainmodule
import com.example.ecommercerugsandtees.di.presentationmodule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShopperApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShopperApp)
            modules(listOf(
                presentationmodule,
                datamodule,
                domainmodule
            ))

        }
    }
}
package com.example.bookcrossingapplication

import android.app.Application
import com.example.bookcrossingapplication.di.dataModule
import com.example.bookcrossingapplication.di.networkModule
import com.example.bookcrossingapplication.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BookCrossingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupDi()
    }

    private fun setupDi() {
        startKoin {
            androidLogger()
            androidContext(this@BookCrossingApplication)
            modules(dataModule, presentationModule, networkModule)
        }
    }
}
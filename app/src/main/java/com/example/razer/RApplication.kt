package com.example.razer

import android.app.Application
import com.example.razer.injection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RApplication)
            modules(listOf(viewModelModule))
        }
    }

}
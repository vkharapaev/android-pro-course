package com.headmostlab.justtranslate

import android.app.Application
import com.headmostlab.justtranslate.di.application
import com.headmostlab.justtranslate.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(application, mainScreen))
        }
    }
}
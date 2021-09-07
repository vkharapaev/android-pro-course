package com.headmostlab.justtranslate

import android.app.Application
import com.headmostlab.justtranslate.di.application
import com.headmostlab.justtranslate.di.mainScreen
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}
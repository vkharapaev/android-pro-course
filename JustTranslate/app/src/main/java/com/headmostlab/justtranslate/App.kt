package com.headmostlab.justtranslate

import android.app.Application
import com.headmostlab.justtranslate.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().applicationContext(this).build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}
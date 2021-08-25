package com.headmostlab.justtranslate.di

import android.content.Context
import com.headmostlab.justtranslate.App
import com.headmostlab.justtranslate.di.scopes.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        FragmentsModule::class,
        SkyEngApiModule::class
    ]
)
interface AppComponent {

    fun inject(application: App)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun applicationContext(context: Context): Builder
    }
}
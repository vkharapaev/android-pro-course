package com.headmostlab.justtranslate.di

import android.content.Context
import com.headmostlab.justtranslate.App
import com.headmostlab.justtranslate.di.modules.ActivitiesModule
import com.headmostlab.justtranslate.di.modules.AppCommonModule
import com.headmostlab.justtranslate.di.modules.FragmentsModule
import com.headmostlab.justtranslate.di.modules.SkyEngApiModule
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
        AppCommonModule::class
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
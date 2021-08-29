package com.headmostlab.justtranslate.di.modules

import com.headmostlab.justtranslate.di.scopes.ActivityScope
import com.headmostlab.justtranslate.presentation.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}

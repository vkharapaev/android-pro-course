package com.headmostlab.justtranslate.di

import com.headmostlab.justtranslate.di.scopes.FragmentScope
import com.headmostlab.justtranslate.presentation.ui.EnterWordFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeEnterWordFragment(): EnterWordFragment
}
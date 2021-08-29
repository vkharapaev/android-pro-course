package com.headmostlab.justtranslate.di.modules

import com.headmostlab.justtranslate.di.scopes.FragmentScope
import com.headmostlab.justtranslate.presentation.ui.fragments.DictionaryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [DictionaryFragmentModule::class, SkyEngApiModule::class])
    fun contributeDictionaryFragment(): DictionaryFragment
}
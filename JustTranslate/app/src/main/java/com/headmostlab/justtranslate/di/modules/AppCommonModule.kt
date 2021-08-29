package com.headmostlab.justtranslate.di.modules

import androidx.lifecycle.ViewModelProvider
import com.headmostlab.justtranslate.domain.interactors.interfaces.Schedulers
import com.headmostlab.justtranslate.presentation.ViewModelFactory
import com.headmostlab.justtranslate.presentation.ui.AndroidSchedulers
import dagger.Binds
import dagger.Module

@Module
interface AppCommonModule {

    @Binds
    fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun provideSchedulers(schedulers: AndroidSchedulers): Schedulers
}
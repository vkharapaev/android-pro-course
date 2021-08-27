package com.headmostlab.justtranslate.di.modules

import com.headmostlab.justtranslate.data.datasources.network.skyeng.SkyEngDictionaryDataSource
import com.headmostlab.justtranslate.data.repositories.DictionaryRepositoryImpl
import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.DictionaryDataSource
import com.headmostlab.justtranslate.domain.interactors.interfaces.Schedulers
import com.headmostlab.justtranslate.domain.interactors.interfaces.presenters.DictionaryPresenter
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository
import com.headmostlab.justtranslate.presentation.presenters.DictionaryPresenterImpl
import com.headmostlab.justtranslate.presentation.ui.AndroidSchedulers
import dagger.Binds
import dagger.Module

@Module
interface AppCommonModule {
    @Binds
    fun provideDictionaryPresenter(presenter: DictionaryPresenterImpl): DictionaryPresenter

    @Binds
    fun provideDictionaryRepository(repository: DictionaryRepositoryImpl): DictionaryRepository

    @Binds
    fun provideDictionaryDataSource(dataSource: SkyEngDictionaryDataSource): DictionaryDataSource

    @Binds
    fun provideSchedulers(schedulers: AndroidSchedulers): Schedulers
}
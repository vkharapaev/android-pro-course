package com.headmostlab.justtranslate.di.modules

import androidx.lifecycle.ViewModel
import com.headmostlab.justtranslate.data.datasources.network.skyeng.SkyEngDictionaryDataSource
import com.headmostlab.justtranslate.data.repositories.DictionaryRepositoryImpl
import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.DictionaryDataSource
import com.headmostlab.justtranslate.di.ViewModelKey
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository
import com.headmostlab.justtranslate.presentation.presenters.DictionaryViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DictionaryFragmentModule {

    @IntoMap
    @ViewModelKey(value = DictionaryViewModelImpl::class)
    @Binds
    fun provideDictionaryViewModel(presenter: DictionaryViewModelImpl): ViewModel

    @Binds
    fun provideDictionaryRepository(repository: DictionaryRepositoryImpl): DictionaryRepository

    @Binds
    fun provideDictionaryDataSource(dataSource: SkyEngDictionaryDataSource): DictionaryDataSource
}
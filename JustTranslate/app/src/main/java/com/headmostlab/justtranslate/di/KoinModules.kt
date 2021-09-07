package com.headmostlab.justtranslate.di

import com.headmostlab.justtranslate.data.datasources.network.skyeng.SkyEngDictionaryDataSource
import com.headmostlab.justtranslate.data.datasources.network.skyeng.SkyEngDictionaryService
import com.headmostlab.justtranslate.data.repositories.DictionaryRepositoryImpl
import com.headmostlab.justtranslate.domain.interactors.DictionaryInteractor
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository
import com.headmostlab.justtranslate.presentation.presenters.DictionaryViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    single { SkyEngDictionaryService.getService(DiConstants.BASE_URL) }
    single<DictionaryRepository> { DictionaryRepositoryImpl(SkyEngDictionaryDataSource(get())) }
}

val mainScreen = module {
    viewModel {
        DictionaryViewModelImpl(DictionaryInteractor(get()))
    }
}

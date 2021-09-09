package com.headmostlab.justtranslate.di

import androidx.room.Room
import com.headmostlab.justtranslate.data.datasources.local.database.CacheDataSourceImpl
import com.headmostlab.justtranslate.data.datasources.local.database.Db
import com.headmostlab.justtranslate.data.datasources.network.skyeng.SkyEngDictionaryDataSource
import com.headmostlab.justtranslate.data.datasources.network.skyeng.SkyEngDictionaryService
import com.headmostlab.justtranslate.data.repositories.DictionaryRepositoryImpl
import com.headmostlab.justtranslate.domain.interactors.DictionaryInteractor
import com.headmostlab.justtranslate.data.repositories.interfaces.network.NetworkStatus
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository
import com.headmostlab.justtranslate.presentation.presenters.DictionaryViewModelImpl
import com.headmostlab.justtranslate.presentation.ui.network.AndroidNetworkStatus
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    single { SkyEngDictionaryService.getService(DiConstants.BASE_URL) }
    single { Room.databaseBuilder(get(), Db::class.java, DiConstants.DB_NAME).build() }
    single<NetworkStatus> { AndroidNetworkStatus(get()) }
    single<DictionaryRepository> {
        val db: Db = get()
        DictionaryRepositoryImpl(
            SkyEngDictionaryDataSource(get()),
            CacheDataSourceImpl(db.allDao()),
            get()
        )
    }
}

val mainScreen = module {
    viewModel {
        DictionaryViewModelImpl(DictionaryInteractor(get()))
    }
}

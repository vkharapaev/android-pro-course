package com.headmostlab.justtranslate.data.repositories

import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.CacheDataSource
import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.DictionaryDataSource
import com.headmostlab.justtranslate.data.repositories.interfaces.network.NetworkStatus
import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository

class DictionaryRepositoryImpl constructor(
    private val dictionaryDataSource: DictionaryDataSource,
    private val cacheDataSource: CacheDataSource,
    private val networkStatus: NetworkStatus
) : DictionaryRepository {
    override suspend fun getTranslations(word: String): List<Translations> {
        return if (networkStatus.isOnline()) {
            dictionaryDataSource.getTranslations(word).also {
                cacheDataSource.saveTranslations(it)
            }
        } else {
            cacheDataSource.getTranslations(word)
        }
    }
}
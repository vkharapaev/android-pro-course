package com.headmostlab.justtranslate.data.datasources.local.database

import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.CacheDataSource
import com.headmostlab.justtranslate.domain.entities.Translations

class CacheDataSourceImpl(private val dao: AllDao) : CacheDataSource {
    override suspend fun getTranslations(word: String): List<Translations> =
        dao.find(word).map { DataConverter.map(it) }

    override suspend fun saveTranslations(translations: List<Translations>) {
        dao.insert(translations)
    }
}
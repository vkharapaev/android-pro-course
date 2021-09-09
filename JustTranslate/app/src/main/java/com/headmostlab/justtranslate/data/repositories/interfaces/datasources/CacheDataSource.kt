package com.headmostlab.justtranslate.data.repositories.interfaces.datasources

import com.headmostlab.justtranslate.domain.entities.Translations

interface CacheDataSource {
    suspend fun getTranslations(word: String): List<Translations>
    suspend fun saveTranslations(translations: List<Translations>)
}
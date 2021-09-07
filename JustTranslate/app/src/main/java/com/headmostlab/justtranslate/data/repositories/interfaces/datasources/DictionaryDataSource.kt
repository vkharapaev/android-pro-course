package com.headmostlab.justtranslate.data.repositories.interfaces.datasources

import com.headmostlab.justtranslate.domain.entities.Translations

interface DictionaryDataSource {
    suspend fun getTranslations(word: String): List<Translations>
}
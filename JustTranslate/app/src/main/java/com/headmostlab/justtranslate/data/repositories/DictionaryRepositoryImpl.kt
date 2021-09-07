package com.headmostlab.justtranslate.data.repositories

import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.DictionaryDataSource
import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository

class DictionaryRepositoryImpl constructor(
    private val dictionaryDataSource: DictionaryDataSource
) : DictionaryRepository {
    override suspend fun getTranslations(word: String): List<Translations> {
        return dictionaryDataSource.getTranslations(word)
    }
}
package com.headmostlab.justtranslate.data.repositories

import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.DictionaryDataSource
import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository
import io.reactivex.rxjava3.core.Single

class DictionaryRepositoryImpl constructor(
    private val dictionaryDataSource: DictionaryDataSource
) : DictionaryRepository {
    override fun getTranslations(word: String): Single<List<Translations>> {
        return dictionaryDataSource.getTranslations(word)
    }
}
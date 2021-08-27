package com.headmostlab.justtranslate.data.repositories.interfaces.datasources

import com.headmostlab.justtranslate.domain.entities.Translations
import io.reactivex.rxjava3.core.Single

interface DictionaryDataSource {
    fun getTranslations(word: String): Single<List<Translations>>
}
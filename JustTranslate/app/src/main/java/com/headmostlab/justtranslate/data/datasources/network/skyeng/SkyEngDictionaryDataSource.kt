package com.headmostlab.justtranslate.data.datasources.network.skyeng

import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.DictionaryDataSource
import com.headmostlab.justtranslate.domain.entities.Translations
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SkyEngDictionaryDataSource constructor(private val skyEngDictionaryApi: SkyEngDictionaryApi) :
    DictionaryDataSource {
    override fun getTranslations(word: String): Single<List<Translations>> {
        return skyEngDictionaryApi.search(word)
    }
}
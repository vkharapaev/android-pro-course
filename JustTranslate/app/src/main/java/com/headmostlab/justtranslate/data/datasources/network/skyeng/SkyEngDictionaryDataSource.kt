package com.headmostlab.justtranslate.data.datasources.network.skyeng

import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.DictionaryDataSource
import com.headmostlab.justtranslate.domain.entities.Translations

class SkyEngDictionaryDataSource constructor(private val skyEngDictionaryApi: SkyEngDictionaryApi) :
    DictionaryDataSource {
    override suspend fun getTranslations(word: String): List<Translations> {
        return skyEngDictionaryApi.search(word)
    }
}
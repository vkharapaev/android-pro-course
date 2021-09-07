package com.headmostlab.justtranslate.domain.interactors.interfaces.repositories

import com.headmostlab.justtranslate.domain.entities.Translations

interface DictionaryRepository {
    suspend fun getTranslations(word: String): List<Translations>
}
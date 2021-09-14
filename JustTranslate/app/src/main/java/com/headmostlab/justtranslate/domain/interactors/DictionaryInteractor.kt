package com.headmostlab.justtranslate.domain.interactors

import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository

class DictionaryInteractor(private val dictionaryRepository: DictionaryRepository) {
    suspend fun getTranslations(word: String): List<Translations> {
        return if (word.length < 3) {
            emptyList()
        } else {
            dictionaryRepository.getTranslations(word)
        }
    }
}
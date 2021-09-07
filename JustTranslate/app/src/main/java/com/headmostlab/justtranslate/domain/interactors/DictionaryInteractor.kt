package com.headmostlab.justtranslate.domain.interactors

import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository
import io.reactivex.rxjava3.core.Single

class DictionaryInteractor constructor(
    private val dictionaryRepository: DictionaryRepository
) {
    fun getTranslations(word: String): Single<List<Translations>> {
        return Single.just(word.trim()).flatMap {
            if (word.length < 3) {
                Single.just(emptyList())
            } else {
                dictionaryRepository.getTranslations(word)
            }
        }
    }
}
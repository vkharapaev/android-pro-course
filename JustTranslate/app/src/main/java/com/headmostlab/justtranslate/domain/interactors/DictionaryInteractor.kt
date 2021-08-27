package com.headmostlab.justtranslate.domain.interactors

import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.DictionaryRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DictionaryInteractor @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
) {
    fun getTranslations(word: String): Single<List<Translations>> {
        return Single.just(word.trim()).flatMap {
            if (word.length < 4) {
                Single.just(emptyList())
            } else {
                dictionaryRepository.getTranslations(word)
            }
        }
    }
}
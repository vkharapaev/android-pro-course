package com.headmostlab.justtranslate.domain.interactors.interfaces.repositories

import com.headmostlab.justtranslate.domain.entities.Translations
import io.reactivex.rxjava3.core.Single

interface DictionaryRepository {
    fun getTranslations(word: String): Single<List<Translations>>
}
package com.headmostlab.justtranslate.domain.interactors.interfaces.repositories

import com.headmostlab.justtranslate.domain.entities.Translations
import io.reactivex.rxjava3.core.Observable

interface SkyEngRepository {
    fun getTranslations(word: String): Observable<Translations>
}
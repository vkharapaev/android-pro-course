package com.headmostlab.justtranslate.data.repositories.interfaces.datasources

import com.headmostlab.justtranslate.domain.entities.Translations
import io.reactivex.rxjava3.core.Observable

interface SkyEngDataSource {
    fun getTranslations(word: String): Observable<Translations>
}
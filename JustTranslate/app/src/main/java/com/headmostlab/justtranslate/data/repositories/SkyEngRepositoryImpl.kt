package com.headmostlab.justtranslate.data.repositories

import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.SkyEngDataSource
import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.interfaces.repositories.SkyEngRepository
import io.reactivex.rxjava3.core.Observable

class SkyEngRepositoryImpl(val skyEngDataSource: SkyEngDataSource) : SkyEngRepository {
    override fun getTranslations(word: String): Observable<Translations> {
        return skyEngDataSource.getTranslations(word)
    }
}
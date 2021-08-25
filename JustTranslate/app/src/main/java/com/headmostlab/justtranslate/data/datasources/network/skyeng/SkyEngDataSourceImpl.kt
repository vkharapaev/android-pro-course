package com.headmostlab.justtranslate.data.datasources.network.skyeng

import com.headmostlab.justtranslate.data.repositories.interfaces.datasources.SkyEngDataSource
import com.headmostlab.justtranslate.domain.entities.Translations
import io.reactivex.rxjava3.core.Observable

class SkyEngDataSourceImpl : SkyEngDataSource {
    override fun getTranslations(word: String): Observable<Translations> {
        TODO("Not yet implemented")
    }
}
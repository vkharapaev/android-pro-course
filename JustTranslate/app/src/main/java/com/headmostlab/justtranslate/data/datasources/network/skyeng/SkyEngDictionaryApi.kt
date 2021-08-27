package com.headmostlab.justtranslate.data.datasources.network.skyeng

import com.headmostlab.justtranslate.domain.entities.Translations
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SkyEngDictionaryApi {
    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Single<List<Translations>>
}
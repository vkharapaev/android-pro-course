package com.headmostlab.justtranslate.data.datasources.network.skyeng

import com.headmostlab.justtranslate.domain.entities.Translations
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface SkyEngApi {
    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<Translations>>
}
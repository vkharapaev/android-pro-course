package com.headmostlab.justtranslate.data.datasources.network.skyeng

import com.headmostlab.justtranslate.domain.entities.Translations
import retrofit2.http.GET
import retrofit2.http.Query

interface SkyEngDictionaryApi {
    @GET("words/search")
    suspend fun search(@Query("search") wordToSearch: String): List<Translations>
}
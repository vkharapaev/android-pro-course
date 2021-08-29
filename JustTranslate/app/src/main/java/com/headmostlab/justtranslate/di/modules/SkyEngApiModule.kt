package com.headmostlab.justtranslate.di.modules

import com.headmostlab.justtranslate.BuildConfig
import com.headmostlab.justtranslate.data.datasources.network.skyeng.SkyEngDictionaryApi
import com.headmostlab.justtranslate.di.scopes.AppScope
import com.headmostlab.justtranslate.di.scopes.FragmentScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class SkyEngApiModule {

    companion object {
        private const val BASE_URL = "https://dictionary.skyeng.ru/api/public/v1/"
    }

    @FragmentScope
    @Provides
    fun provideSkyEngApi(): SkyEngDictionaryApi {

        val client = OkHttpClient.Builder().apply {
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                }
            )
        }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(SkyEngDictionaryApi::class.java)
    }

}
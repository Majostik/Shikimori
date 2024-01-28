package com.majo.shikimori.di.module

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.majo.anime_details.di.AnimeDetailsApiModule
import com.majo.shikimori.animelist.di.AnimeListApiModule
import com.majo.shikimori.manga_list.di.MangaListApiModule
import com.majo.shikimori.retrofit.RetrofitFactory
import com.majo.shikimori.retrofit.RetrofitFactoryImpl
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(
    includes = [
        AnimeListApiModule::class,
        AnimeDetailsApiModule::class,
        MangaListApiModule::class
    ]
)
object ApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl("https://shikimori.one/api/")
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofitFactory(retrofit: Retrofit): RetrofitFactory {
        return RetrofitFactoryImpl(retrofit)
    }

}
package com.majo.shikimori.di.module

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.majo.shikimori.anvil.AppScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@ContributesTo(AppScope::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideJsonKotlinxSerializationFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        return json.asConverterFactory(contentType)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        jsonConverterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://shikimori.one/api/")
            .addConverterFactory(jsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @Named("auth")
    fun provideAuthRetrofit(
        okHttpClient: OkHttpClient,
        jsonConverterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://shikimori.one/oauth/")
            .addConverterFactory(jsonConverterFactory)
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

}
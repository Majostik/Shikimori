package com.majo.shikimori.di.module

import com.google.gson.Gson
import com.majo.anime_details.di.AnimeDetailsApiModule
import com.majo.shikimori.animelist.di.AnimeListApiModule
import com.majo.shikimori.retrofit.RetrofitFactory
import com.majo.shikimori.retrofit.RetrofitFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(
    includes = [
        AnimeListApiModule::class,
        AnimeDetailsApiModule::class
    ]
)
object ApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://shikimori.one/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

}
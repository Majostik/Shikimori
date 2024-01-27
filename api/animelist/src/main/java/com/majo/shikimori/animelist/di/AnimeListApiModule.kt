package com.majo.shikimori.animelist.di

import com.majo.shikimori.animelist.AnimeListApi
import com.majo.shikimori.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AnimeListApiModule {

    @Provides
    @Reusable
    fun provideAnimeFactsApi(retrofitFactory: RetrofitFactory): AnimeListApi {
        return retrofitFactory.create(AnimeListApi::class.java)
    }
}
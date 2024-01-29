package com.majo.shikimori.animelist.di

import com.majo.shikimori.animelist.AnimeListApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AnimeListApiModule {

    @Provides
    @Reusable
    fun provideAnimeFactsApi(retrofit: Retrofit): AnimeListApi {
        return retrofit.create(AnimeListApi::class.java)
    }
}

package com.majo.anime_details.di

import com.majo.anime_details.AnimeDetailsApi
import com.majo.shikimori.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AnimeDetailsApiModule {

    @Provides
    @Reusable
    fun provideAnimeDetailsApi(retrofitFactory: RetrofitFactory): AnimeDetailsApi {
        return retrofitFactory.create(AnimeDetailsApi::class.java)
    }
}
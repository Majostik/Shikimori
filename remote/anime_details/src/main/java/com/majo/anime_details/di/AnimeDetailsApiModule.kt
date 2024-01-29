package com.majo.anime_details.di

import com.majo.anime_details.AnimeDetailsApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AnimeDetailsApiModule {

    @Provides
    @Reusable
    fun provideAnimeDetailsApi(retrofit: Retrofit): AnimeDetailsApi {
        return retrofit.create(AnimeDetailsApi::class.java)
    }
}

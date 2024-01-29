package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsScreenProvider
import com.majo.shikimori.anime_details.AnimeDetailsScreenProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AnimeDetailsScreenProviderModule {

    @Provides
    @Singleton
    fun provideAnimeDetailsScreenProvider(): AnimeDetailsScreenProvider {
        return AnimeDetailsScreenProviderImpl()
    }
}

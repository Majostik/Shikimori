package com.majo.shikimori.animelist.di

import com.majo.shikimori.anime_details.AnimeDetailsScreenProvider
import com.majo.shikimori.animelist.AnimeListScreenProviderImpl
import com.majo.shikimori.animelist_public.AnimeListScreenProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AnimeListScreenProviderModule {


    @Provides
    @Singleton
    fun provideAnimeListScreenProvider(animeDetailsScreenProvider: AnimeDetailsScreenProvider): AnimeListScreenProvider {
        return AnimeListScreenProviderImpl(animeDetailsScreenProvider)
    }
}
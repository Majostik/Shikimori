package com.majo.shikimori.animelist.di

import com.majo.shikimori.anime_details.AnimeDetailsScreenProvider
import com.majo.shikimori.animelist.AnimeListScreenProviderImpl
import com.majo.shikimori.animelist_public.AnimeListScreenProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AnimeListScreenProviderModule {


    @Provides
    @Singleton
    fun provideAnimeListScreenProvider(animeDetailsScreenProvider: AnimeDetailsScreenProvider): AnimeListScreenProvider {
        return AnimeListScreenProviderImpl(animeDetailsScreenProvider)
    }
}
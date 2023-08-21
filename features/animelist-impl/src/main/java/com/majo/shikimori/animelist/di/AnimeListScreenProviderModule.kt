package com.majo.shikimori.animelist.di

import com.majo.shikimori.anime_details.AnimeDetailsScreenProvider
import com.majo.shikimori.animelist.AnimeListScreenProviderImpl
import com.majo.shikimori.animelist_public.AnimeListScreenProvider
import com.majo.shikimori.anvil.AppScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
@ContributesTo(AppScope::class)
class AnimeListScreenProviderModule {


    @Provides
    @Singleton
    fun provideAnimeListScreenProvider(animeDetailsScreenProvider: AnimeDetailsScreenProvider): AnimeListScreenProvider {
        return AnimeListScreenProviderImpl(animeDetailsScreenProvider)
    }
}
package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsScreenProvider
import com.majo.shikimori.anime_details.AnimeDetailsScreenProviderImpl
import com.majo.shikimori.dagger.anvil.AppScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
@ContributesTo(AppScope::class)
class AnimeDetailsScreenProviderModule {


    @Provides
    @Singleton
    fun provideAnimeDetailsScreenProvider(): AnimeDetailsScreenProvider {
        return AnimeDetailsScreenProviderImpl()
    }
}
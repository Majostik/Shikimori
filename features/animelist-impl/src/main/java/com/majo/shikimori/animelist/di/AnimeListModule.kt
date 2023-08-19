package com.majo.shikimori.animelist.di

import com.majo.shikimori.animelist.AnimeListScreenProviderImpl
import com.majo.shikimori.animelist.AnimeListViewModel
import com.majo.shikimori.animelist.mvi.AnimeListFeatureBuilder
import com.majo.shikimori.animelist_public.AnimeListScreenProvider
import com.majo.shikimori.dagger.PerScreen
import dagger.Module
import dagger.Provides

@Module
class AnimeListModule {

    @Provides
    @PerScreen
    fun provideViewModel(featureBuilder: AnimeListFeatureBuilder): AnimeListViewModel {
        return AnimeListViewModel(featureBuilder)
    }

}
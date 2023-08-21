package com.majo.shikimori.animelist.di

import com.majo.shikimori.animelist.AnimeListViewModel
import com.majo.shikimori.animelist.mvi.AnimeListFeatureBuilder
import com.majo.shikimori.anvil.ScreenScope
import com.majo.shikimori.dagger.PerScreen
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(ScreenScope::class)
class AnimeListModule {

    @Provides
    @PerScreen
    fun provideViewModel(featureBuilder: AnimeListFeatureBuilder): AnimeListViewModel {
        return AnimeListViewModel(featureBuilder)
    }

}
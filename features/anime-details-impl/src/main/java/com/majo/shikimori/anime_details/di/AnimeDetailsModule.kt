package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsViewModel
import com.majo.shikimori.anime_details.mvi.AnimeDetailsFeatureBuilder
import com.majo.shikimori.anvil.AppScope
import com.majo.shikimori.anvil.ScreenScope
import com.majo.shikimori.dagger.PerScreen
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(ScreenScope::class)
class AnimeDetailsModule {

    @Provides
    @PerScreen
    fun provideViewModel(featureBuilder: AnimeDetailsFeatureBuilder): AnimeDetailsViewModel {
        return AnimeDetailsViewModel(featureBuilder)
    }

}
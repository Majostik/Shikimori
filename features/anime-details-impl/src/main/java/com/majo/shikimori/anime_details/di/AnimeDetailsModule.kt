package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsViewModel
import com.majo.shikimori.anime_details.mvi.AnimeDetailsFeatureBuilder
import com.majo.shikimori.dagger.PerScreen
import dagger.Module
import dagger.Provides

@Module
class AnimeDetailsModule {

    @Provides
    @PerScreen
    fun provideViewModel(featureBuilder: AnimeDetailsFeatureBuilder): AnimeDetailsViewModel {
        return AnimeDetailsViewModel(featureBuilder)
    }

}
package com.majo.shikimori.animelist.di

import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.animelist.AnimeListApi
import com.majo.shikimori.animelist.AnimeListInteractor
import com.majo.shikimori.animelist.AnimeListInteractorImpl
import com.majo.shikimori.animelist.AnimeListViewModel
import com.majo.shikimori.animelist.mvi.AnimeListFeatureBuilder
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

    @Provides
    @PerScreen
    fun provideAnimeListInteractor(
        animeListApi: AnimeListApi,
        errorConverter: ErrorConverter
    ): AnimeListInteractor {
        return AnimeListInteractorImpl(animeListApi, errorConverter)
    }

}
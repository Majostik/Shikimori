package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsInteractor
import com.majo.shikimori.anime_details.AnimeDetailsInteractorImpl
import com.majo.shikimori.dagger.PerActivity
import dagger.Binds
import dagger.Module

@Module(
    includes = [AnimeDetailsModule.Deps::class]
)
class AnimeDetailsModule {

    @Module
    interface Deps {

        @Binds
        @PerActivity
        fun bindsAnimeDetailsInteractor(animeDetailsInteractor: AnimeDetailsInteractorImpl): AnimeDetailsInteractor

    }
}
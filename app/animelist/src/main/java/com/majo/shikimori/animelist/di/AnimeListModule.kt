package com.majo.shikimori.animelist.di

import com.majo.shikimori.animelist.AnimeListInteractor
import com.majo.shikimori.animelist.AnimeListInteractorImpl
import com.majo.shikimori.dagger.PerActivity
import dagger.Binds
import dagger.Module

@Module(
    includes = [AnimeListModule.Deps::class]
)
class AnimeListModule {

    @Module
    interface Deps {

        @Binds
        @PerActivity
        fun bindsAnimeListInteractor(animeListInteractor: AnimeListInteractorImpl): AnimeListInteractor

    }
}
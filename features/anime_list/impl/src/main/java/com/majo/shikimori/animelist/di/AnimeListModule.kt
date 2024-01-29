package com.majo.shikimori.animelist.di

import com.majo.shikimori.animelist.AnimeListInteractor
import com.majo.shikimori.animelist.AnimeListInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AnimeListModule {

    @Binds
    fun bindsAnimeListInteractor(interactor: AnimeListInteractorImpl): AnimeListInteractor
}

package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsInteractor
import com.majo.shikimori.anime_details.AnimeDetailsInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AnimeDetailsModule {

    @Binds
    fun bindsAnimeDetailsInteractor(interactor: AnimeDetailsInteractorImpl): AnimeDetailsInteractor
}
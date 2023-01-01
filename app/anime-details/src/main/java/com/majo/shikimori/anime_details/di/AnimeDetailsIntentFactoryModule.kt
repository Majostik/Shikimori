package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeListDetailsFactoryImpl
import com.majo.shikimori.navigation.AnimeDetailsIntentFactory
import dagger.Binds
import dagger.Module

@Module
interface AnimeDetailsIntentFactoryModule {
    @Binds
    fun bindIntentFactory(factory: AnimeListDetailsFactoryImpl): AnimeDetailsIntentFactory

}
package com.majo.shikimori.animelist.di

import com.majo.shikimori.animelist.AnimeListIntentFactoryImpl
import com.majo.shikimori.navigation.AnimeListIntentFactory
import dagger.Binds
import dagger.Module

@Module
interface AnimeListIntentFactoryModule {
    @Binds
    fun bindIntentFactory(factory: AnimeListIntentFactoryImpl): AnimeListIntentFactory

}
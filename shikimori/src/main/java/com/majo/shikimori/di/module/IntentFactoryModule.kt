package com.majo.shikimori.di.module

import com.majo.shikimori.anime_details.di.AnimeDetailsIntentFactoryModule
import com.majo.shikimori.animelist.di.AnimeListIntentFactoryModule
import dagger.Module

@Module(
    includes = [
        AnimeListIntentFactoryModule::class,
        AnimeDetailsIntentFactoryModule::class
    ]
)
interface IntentFactoryModule
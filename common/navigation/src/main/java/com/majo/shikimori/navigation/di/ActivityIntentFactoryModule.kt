package com.majo.shikimori.navigation.di

import com.majo.shikimori.navigation.ActivityIntentFactory
import com.majo.shikimori.navigation.ActivityIntentFactoryImpl
import dagger.Binds
import dagger.Module

@Module
interface ActivityIntentFactoryModule {

    @Binds
    fun bindActivityIntentFactory(factory: ActivityIntentFactoryImpl): ActivityIntentFactory
}
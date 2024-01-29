package com.majo.shikimori.di.module

import android.content.Context
import android.content.res.Resources
import com.majo.shikimori.core.ErrorConverter
import com.majo.shikimori.core.ErrorConverterImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
open class AppModule {

    @Provides
    fun provideResources(@ApplicationContext context: Context): Resources {
        return context.resources
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface Bindings {
        @Binds
        @Singleton
        fun providesErrorConverter(errorConverter: ErrorConverterImpl): ErrorConverter
    }
}

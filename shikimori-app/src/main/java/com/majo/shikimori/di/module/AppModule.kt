package com.majo.shikimori.di.module

import android.content.Context
import android.content.res.Resources
import com.majo.shikimori.App
import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.android.ErrorConverterImpl
import com.majo.shikimori.retrofit.RetrofitFactory
import com.majo.shikimori.retrofit.RetrofitFactoryImpl
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

        @Binds
        @Singleton
        fun bindsRetrofitFactory(retrofitFactory: RetrofitFactoryImpl): RetrofitFactory
    }

}
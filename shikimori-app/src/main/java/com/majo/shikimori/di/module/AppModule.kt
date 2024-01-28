package com.majo.shikimori.di.module

import android.content.Context
import android.content.res.Resources
import com.majo.shikimori.App
import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.android.ErrorConverterImpl
import com.majo.shikimori.retrofit.RetrofitFactoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule {

    @Provides
    fun provideContext(app: App): Context {
        return app.applicationContext
    }

    @Provides
    fun provideResources(context: Context): Resources {
        return context.resources
    }

    @Provides
    @Singleton
    fun providesErrorConverter(resources: Resources): ErrorConverter {
        return ErrorConverterImpl(resources)
    }


}
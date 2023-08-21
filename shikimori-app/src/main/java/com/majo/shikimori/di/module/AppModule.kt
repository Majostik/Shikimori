package com.majo.shikimori.di.module

import android.content.Context
import android.content.res.Resources
import com.majo.shikimori.App
import com.majo.shikimori.anvil.AppScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(AppScope::class)
open class AppModule {

    @Provides
    fun provideContext(app: App): Context {
        return app.applicationContext
    }

    @Provides
    fun provideResources(context: Context): Resources {
        return context.resources
    }

}
package com.majo.shikimori.di.component

import com.majo.shikimori.anime_details.di.AnimeDetailsDependencies
import com.majo.shikimori.App
import com.majo.shikimori.animelist.di.AnimeListDependencies
import com.majo.shikimori.di.module.ApiModule
import com.majo.shikimori.di.module.AppModule
import com.majo.shikimori.di.module.DependenciesModule
import com.majo.shikimori.di.module.IntentFactoryModule
import com.majo.shikimori.navigation.di.ActivityIntentFactoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        ActivityIntentFactoryModule::class,
        DependenciesModule::class,
        IntentFactoryModule::class
    ]
)
interface AppComponent:
    AnimeListDependencies,
    AnimeDetailsDependencies
{

    fun inject(app: App)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: App): AppComponent
    }
}
package com.majo.shikimori.di.component

import com.majo.shikimori.anime_details.di.AnimeDetailsDependencies
import com.majo.shikimori.App
import com.majo.shikimori.animelist.di.AnimeListDependencies
import com.majo.shikimori.dagger.anvil.AppScope
import com.majo.shikimori.di.module.ApiModule
import com.majo.shikimori.di.module.DependenciesModule
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@MergeComponent(
    scope = AppScope::class,
    modules = [
        ApiModule::class,
        DependenciesModule::class,
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
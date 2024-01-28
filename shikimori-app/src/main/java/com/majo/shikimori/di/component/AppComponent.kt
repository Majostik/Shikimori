package com.majo.shikimori.di.component

import com.majo.shikimori.App
import com.majo.shikimori.anime_details.di.AnimeDetailsDependencies
import com.majo.shikimori.anime_details.di.AnimeDetailsScreenProviderModule
import com.majo.shikimori.animelist.di.AnimeListDependencies
import com.majo.shikimori.animelist.di.AnimeListScreenProviderModule
import com.majo.shikimori.di.module.ApiModule
import com.majo.shikimori.di.module.AppModule
import com.majo.shikimori.di.module.DependenciesModule
import com.majo.shikimori.home.di.HomeListDependencies
import com.majo.shikimori.manga_list.di.MangaListDependencies
import com.majo.shikimori.manga_list.di.MangaListScreenProviderModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        MangaListScreenProviderModule::class,
        AnimeDetailsScreenProviderModule::class,
        AnimeListScreenProviderModule::class,
        DependenciesModule::class,
    ]
)
interface AppComponent: AnimeListDependencies,
    AnimeDetailsDependencies,
    HomeListDependencies,
    MangaListDependencies {

    fun inject(app: App)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: App): AppComponent
    }
}
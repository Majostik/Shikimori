package com.majo.shikimori.di.module

import com.majo.shikimori.anime_details.di.AnimeDetailsDependencies
import com.majo.shikimori.animelist.di.AnimeListDependencies
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.dagger.ComponentDependenciesKey
import com.majo.shikimori.di.component.AppComponent
import com.majo.shikimori.home.di.HomeListDependencies
import com.majo.shikimori.manga_list.di.MangaListDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(AnimeListDependencies::class)
    abstract fun provideAnimeFactsDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(HomeListDependencies::class)
    abstract fun provideHomeListDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(AnimeDetailsDependencies::class)
    abstract fun provideAnimeDetailsDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(MangaListDependencies::class)
    abstract fun provideMangaListDependencies(component: AppComponent): ComponentDependencies

}
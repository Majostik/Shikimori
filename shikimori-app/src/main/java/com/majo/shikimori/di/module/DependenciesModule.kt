package com.majo.shikimori.di.module

import com.majo.shikimori.anime_details.di.AnimeDetailsDependencies
import com.majo.shikimori.animelist.di.AnimeListDependencies
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.dagger.ComponentDependenciesKey
import com.majo.shikimori.dagger.anvil.AppScope
import com.majo.shikimori.di.component.AppComponent
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@ContributesTo(AppScope::class)
abstract class DependenciesModule private constructor(){

    @Binds
    @IntoMap
    @ComponentDependenciesKey(AnimeListDependencies::class)
    abstract fun provideAnimeFactsDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(AnimeDetailsDependencies::class)
    abstract fun provideAnimeDetailsDependencies(component: AppComponent): ComponentDependencies

}
package com.majo.shikimori.di

import com.majo.shikimori.anime_details.di.AnimeDetailsDependencies
import com.majo.shikimori.animelist.di.AnimeListDependencies
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.di.component.AppEntryPoint
import com.majo.shikimori.home.di.HomeListDependencies
import com.majo.shikimori.manga_list.di.MangaListDependencies
import dagger.hilt.EntryPoints

object DependenciesManager {
    
    fun getDependencies(appEntryPoint: AppEntryPoint): Map<Class<out ComponentDependencies>, @JvmSuppressWildcards ComponentDependencies> {
        return buildMap<Class<out ComponentDependencies>, @JvmSuppressWildcards ComponentDependencies> {
            this[AnimeListDependencies::class.java] = appEntryPoint
            this[AnimeDetailsDependencies::class.java] = appEntryPoint
            this[HomeListDependencies::class.java] = appEntryPoint
            this[MangaListDependencies::class.java] = appEntryPoint
        }
    }
}
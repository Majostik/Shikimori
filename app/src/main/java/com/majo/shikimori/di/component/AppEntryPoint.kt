package com.majo.shikimori.di.component

import com.majo.shikimori.anime_details.di.AnimeDetailsDependencies
import com.majo.shikimori.animelist.di.AnimeListDependencies
import com.majo.shikimori.home.di.HomeListDependencies
import com.majo.shikimori.manga_list.di.MangaListDependencies
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
interface AppEntryPoint :
    AnimeListDependencies,
    AnimeDetailsDependencies,
    MangaListDependencies,
    HomeListDependencies
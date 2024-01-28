package com.majo.shikimori.home.di

import com.majo.shikimori.animelist_public.AnimeListScreenProvider
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.manga_list.MangaListScreenProvider

interface HomeListDependencies: ComponentDependencies {

    fun animeListScreenProvider(): AnimeListScreenProvider

    fun mangaListScreenProvider(): MangaListScreenProvider

}
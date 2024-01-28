package com.majo.shikimori.manga_list.di

import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.manga_list.MangaListApi

interface MangaListDependencies: ComponentDependencies {
    fun mangaListApi(): MangaListApi
    fun errorConverter(): ErrorConverter

}
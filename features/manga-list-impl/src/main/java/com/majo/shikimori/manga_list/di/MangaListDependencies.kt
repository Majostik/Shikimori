package com.majo.shikimori.manga_list.di

import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.manga_list.MangaListApi
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

interface MangaListDependencies: ComponentDependencies {
    fun mangaListApi(): MangaListApi

}
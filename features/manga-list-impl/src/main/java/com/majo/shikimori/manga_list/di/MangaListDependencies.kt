package com.majo.shikimori.manga_list.di

import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.anvil.AppScope
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.manga_list.MangaListApi
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface MangaListDependencies: ComponentDependencies {
    fun mangaListApi(): MangaListApi
    fun errorConverter(): ErrorConverter

}
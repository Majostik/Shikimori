package com.majo.shikimori.animelist.di

import android.content.Context
import com.majo.shikimori.animelist.AnimeListApi
import com.majo.shikimori.dagger.ComponentDependencies

interface AnimeListDependencies: ComponentDependencies {
    fun context(): Context
    fun animeListApi(): AnimeListApi
}
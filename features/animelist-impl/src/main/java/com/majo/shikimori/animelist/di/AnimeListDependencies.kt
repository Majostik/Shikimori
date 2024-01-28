package com.majo.shikimori.animelist.di

import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.anime_details.AnimeDetailsScreenProvider
import com.majo.shikimori.animelist.AnimeListApi
import com.majo.shikimori.dagger.ComponentDependencies

interface AnimeListDependencies: ComponentDependencies {
    fun animeListApi(): AnimeListApi

    fun animeDetailsScreenProvider(): AnimeDetailsScreenProvider

    fun errorConverter(): ErrorConverter

}
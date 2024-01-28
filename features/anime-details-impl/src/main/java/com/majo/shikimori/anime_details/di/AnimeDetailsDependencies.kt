package com.majo.shikimori.anime_details.di

import com.majo.anime_details.AnimeDetailsApi
import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.dagger.ComponentDependencies

interface AnimeDetailsDependencies: ComponentDependencies {
    fun animeDetailsApi(): AnimeDetailsApi

    fun errorConverter(): ErrorConverter
}
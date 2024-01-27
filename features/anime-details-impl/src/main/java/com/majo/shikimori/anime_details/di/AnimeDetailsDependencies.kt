package com.majo.shikimori.anime_details.di

import com.majo.anime_details.AnimeDetailsApi
import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.dagger.ComponentDependencies
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

interface AnimeDetailsDependencies: ComponentDependencies {
    fun animeDetailsApi(): AnimeDetailsApi

}
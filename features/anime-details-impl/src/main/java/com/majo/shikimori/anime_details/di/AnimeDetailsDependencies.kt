package com.majo.shikimori.anime_details.di

import com.majo.anime_details.AnimeDetailsApi
import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.anvil.AppScope
import com.majo.shikimori.dagger.ComponentDependencies
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface AnimeDetailsDependencies: ComponentDependencies {
    fun animeDetailsApi(): AnimeDetailsApi

    fun errorConverter(): ErrorConverter
}
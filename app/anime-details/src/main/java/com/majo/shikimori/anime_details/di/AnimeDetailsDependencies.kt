package com.majo.shikimori.anime_details.di

import android.content.Context
import com.majo.anime_details.AnimeDetailsApi
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.dagger.anvil.AppScope
import com.majo.shikimori.navigation.ActivityIntentFactory
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface AnimeDetailsDependencies: ComponentDependencies {
    fun context(): Context
    fun animeDetailsApi(): AnimeDetailsApi
    fun activityIntentFactory(): ActivityIntentFactory
}
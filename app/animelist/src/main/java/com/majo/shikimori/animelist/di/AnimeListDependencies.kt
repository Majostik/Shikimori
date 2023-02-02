package com.majo.shikimori.animelist.di

import android.content.Context
import com.majo.shikimori.animelist.AnimeListApi
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.dagger.anvil.AppScope
import com.majo.shikimori.navigation.ActivityIntentFactory
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface AnimeListDependencies: ComponentDependencies {
    fun context(): Context
    fun animeListApi(): AnimeListApi
    fun activityIntentFactory(): ActivityIntentFactory
}
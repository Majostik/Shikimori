package com.majo.shikimori.animelist.di

import com.majo.shikimori.animelist.AnimeListApi
import com.majo.shikimori.dagger.anvil.AppScope
import com.majo.shikimori.retrofit.RetrofitFactory
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
@ContributesTo(AppScope::class)
object AnimeListApiModule {

    @Provides
    @Reusable
    fun provideAnimeFactsApi(retrofitFactory: RetrofitFactory): AnimeListApi {
        return retrofitFactory.create(AnimeListApi::class.java)
    }
}
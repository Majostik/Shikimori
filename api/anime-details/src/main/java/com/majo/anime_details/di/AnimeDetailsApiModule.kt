package com.majo.anime_details.di

import com.majo.anime_details.AnimeDetailsApi
import com.majo.shikimori.anvil.AppScope
import com.majo.shikimori.retrofit.RetrofitFactory
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
@ContributesTo(AppScope::class)
object AnimeDetailsApiModule {

    @Provides
    @Reusable
    fun provideAnimeDetailsApi(retrofitFactory: RetrofitFactory): AnimeDetailsApi {
        return retrofitFactory.create(AnimeDetailsApi::class.java)
    }
}
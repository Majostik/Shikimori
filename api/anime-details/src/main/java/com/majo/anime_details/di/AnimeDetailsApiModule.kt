package com.majo.anime_details.di

import com.majo.anime_details.AnimeDetailsApi
import com.majo.shikimori.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object AnimeDetailsApiModule {

    @Provides
    @Reusable
    fun provideAnimeDetailsApi(retrofitFactory: RetrofitFactory): AnimeDetailsApi {
        return retrofitFactory.create(AnimeDetailsApi::class.java)
    }
}
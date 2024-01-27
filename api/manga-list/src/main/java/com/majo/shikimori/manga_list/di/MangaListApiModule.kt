package com.majo.shikimori.manga_list.di

import com.majo.shikimori.manga_list.MangaListApi
import com.majo.shikimori.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MangaListApiModule {

    @Provides
    @Reusable
    fun provideMangaListApi(retrofitFactory: RetrofitFactory): MangaListApi {
        return retrofitFactory.create(MangaListApi::class.java)
    }
}
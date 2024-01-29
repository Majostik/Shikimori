package com.majo.shikimori.manga_list.di

import com.majo.shikimori.manga_list.MangaListApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object MangaListApiModule {

    @Provides
    @Reusable
    fun provideMangaListApi(retrofit: Retrofit): MangaListApi {
        return retrofit.create(MangaListApi::class.java)
    }
}

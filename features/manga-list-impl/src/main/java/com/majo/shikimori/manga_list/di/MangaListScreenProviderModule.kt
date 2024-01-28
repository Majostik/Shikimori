package com.majo.shikimori.manga_list.di

import com.majo.shikimori.manga_list.MangaListScreenProvider
import com.majo.shikimori.manga_list.MangaListScreenProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MangaListScreenProviderModule {


    @Provides
    @Singleton
    fun provideMangaListScreenProvider(): MangaListScreenProvider {
        return MangaListScreenProviderImpl()
    }
}
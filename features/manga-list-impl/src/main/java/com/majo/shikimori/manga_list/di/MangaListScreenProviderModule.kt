package com.majo.shikimori.manga_list.di

import com.majo.shikimori.anvil.AppScope
import com.majo.shikimori.manga_list.MangaListScreenProvider
import com.majo.shikimori.manga_list.MangaListScreenProviderImpl
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
@ContributesTo(AppScope::class)
class MangaListScreenProviderModule {


    @Provides
    @Singleton
    fun provideMangaListScreenProvider(): MangaListScreenProvider {
        return MangaListScreenProviderImpl()
    }
}
package com.majo.shikimori.manga_list.di

import com.majo.shikimori.anvil.AppScope
import com.majo.shikimori.manga_list.MangaListApi
import com.majo.shikimori.retrofit.RetrofitFactory
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
@ContributesTo(AppScope::class)
object MangaListApiModule {

    @Provides
    @Reusable
    fun provideMangaListApi(retrofitFactory: RetrofitFactory): MangaListApi {
        return retrofitFactory.create(MangaListApi::class.java)
    }
}
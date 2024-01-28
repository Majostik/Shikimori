package com.majo.shikimori.manga_list.di

import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.dagger.PerScreen
import com.majo.shikimori.manga_list.MangaListApi
import com.majo.shikimori.manga_list.MangaListInteractor
import com.majo.shikimori.manga_list.MangaListInteractorImpl
import com.majo.shikimori.manga_list.MangaListViewModel
import com.majo.shikimori.manga_list.mvi.MangaListFeatureBuilder
import dagger.Module
import dagger.Provides

@Module
class MangaListModule {

    @Provides
    @PerScreen
    fun provideViewModel(featureBuilder: MangaListFeatureBuilder): MangaListViewModel {
        return MangaListViewModel(featureBuilder)
    }

    @Provides
    @PerScreen
    fun provideMangaListInteractor(
        mangaListApi: MangaListApi,
        errorConverter: ErrorConverter
    ): MangaListInteractor {
        return MangaListInteractorImpl(mangaListApi, errorConverter)
    }
}
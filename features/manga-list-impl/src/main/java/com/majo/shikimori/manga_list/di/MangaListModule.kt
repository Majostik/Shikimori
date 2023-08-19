package com.majo.shikimori.manga_list.di

import com.majo.shikimori.dagger.PerScreen
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

}
package com.majo.shikimori.manga_list.di

import com.majo.shikimori.anvil.ScreenScope
import com.majo.shikimori.dagger.PerScreen
import com.majo.shikimori.manga_list.MangaListViewModel
import com.majo.shikimori.manga_list.mvi.MangaListFeatureBuilder
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(ScreenScope::class)
class MangaListModule {

    @Provides
    @PerScreen
    fun provideViewModel(featureBuilder: MangaListFeatureBuilder): MangaListViewModel {
        return MangaListViewModel(featureBuilder)
    }

}
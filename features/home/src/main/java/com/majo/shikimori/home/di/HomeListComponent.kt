package com.majo.shikimori.home.di

import com.majo.shikimori.animelist_public.AnimeListScreenProvider
import com.majo.shikimori.anvil.ScreenScope
import com.majo.shikimori.dagger.PerScreen
import com.majo.shikimori.manga_list.MangaListScreenProvider
import com.squareup.anvil.annotations.MergeComponent
import dagger.Component

@MergeComponent(
    scope = ScreenScope::class,
    dependencies = [HomeListDependencies::class],
)
@PerScreen
interface HomeListComponent {

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: HomeListDependencies
        ): HomeListComponent
    }

    fun animeListScreenProvider(): AnimeListScreenProvider

    fun mangaListScreenProvider(): MangaListScreenProvider

}
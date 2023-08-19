package com.majo.shikimori.animelist.di

import com.majo.shikimori.anime_details.AnimeDetailsScreenProvider
import com.majo.shikimori.animelist.AnimeListViewModel
import com.majo.shikimori.dagger.PerScreen
import com.majo.shikimori.dagger.anvil.ScreenScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.Component

@MergeComponent(
    scope = ScreenScope::class,
    modules = [AnimeListModule::class],
    dependencies = [AnimeListDependencies::class],
)
@PerScreen
interface AnimeListComponent {

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: AnimeListDependencies
        ): AnimeListComponent
    }

    fun viewModel(): AnimeListViewModel

    fun animeDetailsScreenProvider(): AnimeDetailsScreenProvider
}
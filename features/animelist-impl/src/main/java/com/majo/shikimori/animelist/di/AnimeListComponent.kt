package com.majo.shikimori.animelist.di

import com.majo.shikimori.anime_details.AnimeDetailsScreenProvider
import com.majo.shikimori.animelist.AnimeListViewModel
import com.majo.shikimori.dagger.PerScreen
import dagger.Component

@Component(
    dependencies = [AnimeListDependencies::class],
    modules = [AnimeListModule::class]
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
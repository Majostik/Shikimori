package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsViewModel
import com.majo.shikimori.dagger.PerScreen
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [AnimeDetailsDependencies::class],
    modules = [AnimeDetailsModule::class]
)
@PerScreen
interface AnimeDetailsComponent {

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: AnimeDetailsDependencies,
            @BindsInstance id: Long
        ): AnimeDetailsComponent
    }

    fun viewModel(): AnimeDetailsViewModel

}
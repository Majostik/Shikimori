package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsViewModel
import com.majo.shikimori.anvil.ScreenScope
import com.majo.shikimori.dagger.PerScreen
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@MergeComponent(
    scope = ScreenScope::class,
    dependencies = [AnimeDetailsDependencies::class],
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
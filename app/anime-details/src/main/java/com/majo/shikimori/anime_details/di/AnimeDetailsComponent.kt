package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsActivity
import com.majo.shikimori.dagger.PerActivity
import com.majo.shikimori.dagger.anvil.ActivityScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@MergeComponent(
    scope = ActivityScope::class,
    dependencies = [AnimeDetailsDependencies::class],
)
@PerActivity
interface AnimeDetailsComponent {

    fun inject(activity: AnimeDetailsActivity)

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: AnimeDetailsDependencies,
            @BindsInstance id: Long
        ): AnimeDetailsComponent
    }
}
package com.majo.shikimori.anime_details.di

import com.majo.shikimori.anime_details.AnimeDetailsActivity
import com.majo.shikimori.dagger.PerActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [AnimeDetailsDependencies::class],
    modules = [AnimeDetailsModule::class]
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
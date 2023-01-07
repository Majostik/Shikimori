package com.majo.shikimori.animelist.di

import com.majo.shikimori.animelist.AnimeListActivity
import com.majo.shikimori.dagger.PerActivity
import com.majo.shikimori.dagger.anvil.ActivityScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.Component

@MergeComponent(
    scope = ActivityScope::class,
    dependencies = [AnimeListDependencies::class],
)
@PerActivity
interface AnimeListComponent {

    fun inject(activity: AnimeListActivity)

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: AnimeListDependencies
        ): AnimeListComponent
    }
}
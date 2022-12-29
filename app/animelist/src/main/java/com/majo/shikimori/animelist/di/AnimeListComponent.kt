package com.majo.shikimori.animelist.di

import androidx.lifecycle.ViewModelStore
import com.majo.shikimori.animelist.AnimeListActivity
import com.majo.shikimori.dagger.PerActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [AnimeListDependencies::class]
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
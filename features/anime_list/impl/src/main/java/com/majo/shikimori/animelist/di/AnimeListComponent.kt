package com.majo.shikimori.animelist.di

import dagger.Component

@Component(
    dependencies = [AnimeListDependencies::class]
)
interface AnimeListComponent: AnimeListDependencies {
    @Component.Builder
    interface Builder {
        fun dependencies(appComponent: AnimeListDependencies): Builder
        fun build(): AnimeListComponent
    }
}
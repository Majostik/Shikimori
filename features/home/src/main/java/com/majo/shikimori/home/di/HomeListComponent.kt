package com.majo.shikimori.home.di

import dagger.Component

@Component(
    dependencies = [HomeListDependencies::class]
)
interface HomeListComponent: HomeListDependencies {
    @Component.Builder
    interface Builder {
        fun dependencies(appComponent: HomeListDependencies): Builder
        fun build(): HomeListComponent
    }
}
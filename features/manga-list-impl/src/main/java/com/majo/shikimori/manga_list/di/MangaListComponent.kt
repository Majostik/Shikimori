package com.majo.shikimori.manga_list.di

import com.majo.shikimori.dagger.PerScreen
import com.majo.shikimori.dagger.anvil.ScreenScope
import com.majo.shikimori.manga_list.MangaListViewModel
import com.squareup.anvil.annotations.MergeComponent
import dagger.Component

@MergeComponent(
    scope = ScreenScope::class,
    modules = [MangaListModule::class],
    dependencies = [MangaListDependencies::class],
)
@PerScreen
interface MangaListComponent {

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: MangaListDependencies
        ): MangaListComponent
    }

    fun viewModel(): MangaListViewModel

}
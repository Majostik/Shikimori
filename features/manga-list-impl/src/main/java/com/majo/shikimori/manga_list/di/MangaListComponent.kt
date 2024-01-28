package com.majo.shikimori.manga_list.di

import com.majo.shikimori.dagger.PerScreen
import com.majo.shikimori.manga_list.MangaListViewModel
import dagger.Component

@Component(
    dependencies = [MangaListDependencies::class],
    modules = [MangaListModule::class]
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
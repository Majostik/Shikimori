package com.majo.shikimori.manga_list.di

import com.majo.shikimori.manga_list.MangaListInteractor
import com.majo.shikimori.manga_list.MangaListInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MangaListModule {

    @Binds
    fun bindsMangaListInteractor(interactor: MangaListInteractorImpl): MangaListInteractor
}

package com.majo.shikimori.manga_list.mvi

import com.majo.shikimori.manga_list.MangaListInteractor
import com.majo.shikimori.manga_list.mvi.entity.MangaListInternalAction
import com.majo.shikimori.mvi.Bootstrap
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MangaListBootstrap @Inject constructor(
    private val interactor: MangaListInteractor
) : Bootstrap<MangaListInternalAction>{
    override fun produce(): Flow<MangaListInternalAction> {
        return interactor.loadManga(1, 20)
    }

}
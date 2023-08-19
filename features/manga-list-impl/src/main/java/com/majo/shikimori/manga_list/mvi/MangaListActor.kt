package com.majo.shikimori.manga_list.mvi

import com.majo.shikimori.manga_list.MangaListInteractor
import com.majo.shikimori.manga_list.mvi.entity.MangaListAction
import com.majo.shikimori.manga_list.mvi.entity.MangaListInternalAction
import com.majo.shikimori.manga_list.mvi.entity.MangaListState
import com.majo.shikimori.mvi.Actor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MangaListActor @Inject constructor(
    private val interactor: MangaListInteractor,
): Actor<MangaListAction, MangaListInternalAction, MangaListState> {
    override fun process(
        action: MangaListAction,
        previousState: MangaListState
    ): Flow<MangaListInternalAction> = when(action){
        is MangaListAction.Retry -> interactor.loadManga(page = INIT_PAGE, limit = DEFAULT_LIMIT)
        is MangaListAction.LoadNextPage -> interactor.loadManga(page = action.page, limit = DEFAULT_LIMIT)
    }

    companion object {
        const val DEFAULT_LIMIT = 20
        const val INIT_PAGE = 1
    }
}
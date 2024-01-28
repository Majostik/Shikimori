package com.majo.shikimori.manga_list.mvi

import com.majo.shikimori.manga_list.MangaListInteractor
import com.majo.shikimori.manga_list.mvi.entity.MangaListAction
import com.majo.shikimori.manga_list.mvi.entity.MangaListInternalAction
import com.majo.shikimori.manga_list.mvi.entity.MangaListState
import com.majo.shikimori.mvi.Actor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class MangaListActor @Inject constructor(
    private val interactor: MangaListInteractor,
): Actor<MangaListAction, MangaListInternalAction, MangaListState> {
    override fun process(
        action: MangaListAction,
        previousState: MangaListState
    ): Flow<MangaListInternalAction> = when(action){
        is MangaListAction.Retry, is MangaListAction.Init -> interactor.loadManga(page = INIT_PAGE, limit = DEFAULT_LIMIT, query = previousState.query)
        is MangaListAction.LoadNextPage -> interactor.loadManga(page = action.page, limit = DEFAULT_LIMIT, query = previousState.query)
        is MangaListAction.Search -> merge(
            flow { emit(MangaListInternalAction.Clear) },
            interactor.loadManga(page = INIT_PAGE, limit = DEFAULT_LIMIT, query = action.query)
        )
    }

    companion object {
        const val DEFAULT_LIMIT = 20
        const val INIT_PAGE = 1
    }
}
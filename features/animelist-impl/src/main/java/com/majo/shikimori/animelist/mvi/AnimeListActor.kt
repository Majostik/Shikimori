package com.majo.shikimori.animelist.mvi

import com.majo.shikimori.animelist.AnimeListInteractor
import com.majo.shikimori.animelist.mvi.entity.AnimeListAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListInternalAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListState
import com.majo.shikimori.mvi.Actor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class AnimeListActor @Inject constructor(
    private val interactor: AnimeListInteractor,
): Actor<AnimeListAction, AnimeListInternalAction, AnimeListState> {
    override fun process(
        action: AnimeListAction,
        previousState: AnimeListState
    ): Flow<AnimeListInternalAction> = when(action){
        is AnimeListAction.Retry, is AnimeListAction.Init -> interactor.loadAnime(page = INIT_PAGE, limit = DEFAULT_LIMIT, query = previousState.query)
        is AnimeListAction.LoadNextPage -> interactor.loadAnime(page = action.page, limit = DEFAULT_LIMIT, query = previousState.query)
        is AnimeListAction.Search -> merge(
            flow { emit(AnimeListInternalAction.Clear) },
            interactor.loadAnime(page = INIT_PAGE, limit = DEFAULT_LIMIT, query = action.query)
        )
        is AnimeListAction.OpenAnimeDetailsScreen -> flow {
            emit(AnimeListInternalAction.OpenScreen(action.id, action.name))
        }

    }

    companion object {
        const val DEFAULT_LIMIT = 20
        const val INIT_PAGE = 1
    }
}
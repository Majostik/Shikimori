package com.majo.shikimori.animelist.mvi

import com.majo.shikimori.animelist.AnimeListInteractor
import com.majo.shikimori.animelist.mvi.entity.AnimeListAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListInternalAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListState
import com.majo.shikimori.mvi.Actor
import com.majo.shikimori.navigation.ActivityIntentFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AnimeListActor @Inject constructor(
    private val interactor: AnimeListInteractor,
    private val intentFactory: ActivityIntentFactory
): Actor<AnimeListAction, AnimeListInternalAction, AnimeListState> {
    override fun process(
        action: AnimeListAction,
        previousState: AnimeListState
    ): Flow<AnimeListInternalAction> = when(action){
        is AnimeListAction.Retry -> interactor.loadAnime(page = INIT_PAGE, limit = DEFAULT_LIMIT)
        is AnimeListAction.LoadNextPage -> interactor.loadAnime(page = action.page, limit = DEFAULT_LIMIT)
        is AnimeListAction.OpenAnimeDetailsScreen -> flow {
            emit(AnimeListInternalAction.OpenScreen(intentFactory.animeDetailsIntent(action.id)))
        }
    }

    companion object {
        const val DEFAULT_LIMIT = 20
        const val INIT_PAGE = 1
    }
}
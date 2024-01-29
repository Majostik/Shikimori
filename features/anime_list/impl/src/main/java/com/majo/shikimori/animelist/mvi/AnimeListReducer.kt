package com.majo.shikimori.animelist.mvi

import com.majo.shikimori.animelist.mvi.entity.AnimeListInternalAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListState
import com.majo.shikimori.mvi.Reducer
import javax.inject.Inject

class AnimeListReducer @Inject constructor() : Reducer<AnimeListInternalAction, AnimeListState> {
    override fun reduce(
        internalAction: AnimeListInternalAction,
        previousState: AnimeListState,
    ): AnimeListState {
        return when (internalAction) {
            is AnimeListInternalAction.Clear -> {
                AnimeListState.INITIAL
            }
            is AnimeListInternalAction.AnimeLoaded -> {
                previousState.copy(
                    animeList = previousState.animeList + internalAction.anime,
                    page = previousState.page + 1,
                    isLoading = false,
                    query = internalAction.query,
                )
            }
            is AnimeListInternalAction.AnimeLoading, is AnimeListInternalAction.FirstAnimeLoading -> {
                previousState.copy(isLoading = true)
            }
            is AnimeListInternalAction.AnimeError -> {
                previousState.copy(isLoading = false)
            }
            else -> previousState
        }
    }
}

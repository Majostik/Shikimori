package com.majo.shikimori.anime_details.mvi

import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsInternalAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsState
import com.majo.shikimori.core.LoadableState
import com.majo.shikimori.mvi.Reducer
import javax.inject.Inject

class AnimeDetailsReducer @Inject constructor() : Reducer<AnimeDetailsInternalAction, AnimeDetailsState> {
    override fun reduce(
        internalAction: AnimeDetailsInternalAction,
        previousState: AnimeDetailsState,
    ): AnimeDetailsState {
        return when (internalAction) {
            is AnimeDetailsInternalAction.AnimeLoaded -> {
                previousState.copy(data = LoadableState.Loaded(internalAction.anime))
            }
            is AnimeDetailsInternalAction.AnimeLoading -> {
                previousState.copy(data = LoadableState.Loading())
            }
            is AnimeDetailsInternalAction.AnimeError -> {
                previousState.copy(data = LoadableState.Error(internalAction.error))
            }
            else -> previousState
        }
    }
}

package com.majo.shikimori.anime_details.mvi

import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsInternalAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsState
import com.majo.shikimori.mvi.Reducer
import javax.inject.Inject

class AnimeDetailsReducer @Inject constructor(): Reducer<AnimeDetailsInternalAction, AnimeDetailsState> {
    override fun reduce(
        internalAction: AnimeDetailsInternalAction,
        previousState: AnimeDetailsState
    ): AnimeDetailsState {
        return when(internalAction) {
            is AnimeDetailsInternalAction.AnimeLoaded -> {
                previousState.copy(animeDetails = internalAction.anime)
            }
            else -> previousState
        }
    }
}
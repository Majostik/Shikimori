package com.majo.shikimori.anime_details.mvi

import com.majo.shikimori.anime_details.AnimeDetailsInteractor
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsInternalAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsState
import com.majo.shikimori.mvi.Actor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AnimeDetailsActor @Inject constructor(
    private val interactor: AnimeDetailsInteractor,
) : Actor<AnimeDetailsAction, AnimeDetailsInternalAction, AnimeDetailsState> {
    override fun process(
        action: AnimeDetailsAction,
        previousState: AnimeDetailsState,
    ): Flow<AnimeDetailsInternalAction> = when (action) {
        is AnimeDetailsAction.Back -> flow {
            emit(AnimeDetailsInternalAction.Close)
        }
        is AnimeDetailsAction.LoadData -> {
            interactor.getAnimeDetails(action.id)
        }
    }
}

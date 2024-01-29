package com.majo.shikimori.anime_details.mvi

import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsInternalAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsOneTimeEvent
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsState
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsState.Companion.INITIAL
import com.majo.shikimori.mvi.FeatureBuilder
import javax.inject.Inject

class AnimeDetailsFeatureBuilder @Inject constructor(
    reducer: AnimeDetailsReducer,
    actor: AnimeDetailsActor,
    oneTimeEventReducer: AnimeDetailsOneTimeEventReducer,
) : FeatureBuilder<AnimeDetailsAction, AnimeDetailsInternalAction, AnimeDetailsState, AnimeDetailsOneTimeEvent>(
    initialState = INITIAL,
    setupFunc = {
        withActor(actor)
            .withReducer(reducer)
            .withEventReducer(oneTimeEventReducer)
    },
)

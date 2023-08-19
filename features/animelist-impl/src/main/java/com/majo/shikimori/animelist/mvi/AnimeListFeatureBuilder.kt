package com.majo.shikimori.animelist.mvi

import com.majo.shikimori.animelist.mvi.entity.AnimeListAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListInternalAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListOneTimeEvent
import com.majo.shikimori.animelist.mvi.entity.AnimeListState
import com.majo.shikimori.animelist.mvi.entity.AnimeListState.Companion.INITIAL
import com.majo.shikimori.mvi.FeatureBuilder
import javax.inject.Inject

class AnimeListFeatureBuilder @Inject constructor(
    bootstrap: AnimeListBootstrap,
    reducer: AnimeListReducer,
    actor: AnimeListActor,
    oneTimeEventReducer: AnimeListOneTimeEventReducer
): FeatureBuilder<AnimeListAction, AnimeListInternalAction, AnimeListState, AnimeListOneTimeEvent>(
    initialState = INITIAL,
    setupFunc = {
        withBootstrap(bootstrap)
            .withReducer(reducer)
            .withActor(actor)
            .withEventReducer(oneTimeEventReducer)
    }
)
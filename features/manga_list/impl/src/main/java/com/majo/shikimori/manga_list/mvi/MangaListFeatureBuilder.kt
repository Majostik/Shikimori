package com.majo.shikimori.manga_list.mvi

import com.majo.shikimori.manga_list.mvi.entity.MangaListAction
import com.majo.shikimori.manga_list.mvi.entity.MangaListInternalAction
import com.majo.shikimori.manga_list.mvi.entity.MangaListOneTimeEvent
import com.majo.shikimori.manga_list.mvi.entity.MangaListState
import com.majo.shikimori.manga_list.mvi.entity.MangaListState.Companion.INITIAL
import com.majo.shikimori.mvi.FeatureBuilder
import javax.inject.Inject

class MangaListFeatureBuilder @Inject constructor(
    reducer: MangaListReducer,
    actor: MangaListActor,
    oneTimeEventReducer: MangaListOneTimeEventReducer,
) : FeatureBuilder<MangaListAction, MangaListInternalAction, MangaListState, MangaListOneTimeEvent>(
    initialState = INITIAL,
    setupFunc = {
        withReducer(reducer)
            .withActor(actor)
            .withEventReducer(oneTimeEventReducer)
    },
)

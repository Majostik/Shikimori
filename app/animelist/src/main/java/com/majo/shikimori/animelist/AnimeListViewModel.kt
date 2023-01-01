package com.majo.shikimori.animelist

import com.majo.shikimori.animelist.mvi.AnimeListFeatureBuilder
import com.majo.shikimori.animelist.mvi.entity.AnimeListAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListOneTimeEvent
import com.majo.shikimori.animelist.mvi.entity.AnimeListState
import com.majo.shikimori.mvi.MviViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class AnimeListViewModel @AssistedInject constructor(
    featureBuilder: AnimeListFeatureBuilder,
): MviViewModel<AnimeListAction, AnimeListState, AnimeListOneTimeEvent>(
    featureBuilder = featureBuilder
) {
    @AssistedFactory
    interface Factory {
        fun create(): AnimeListViewModel
    }
}
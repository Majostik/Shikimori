package com.majo.shikimori.anime_details

import com.majo.shikimori.anime_details.mvi.AnimeDetailsFeatureBuilder
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsOneTimeEvent
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsState
import com.majo.shikimori.dagger.anvil.ActivityScope
import com.majo.shikimori.dagger.anvil.AppScope
import com.majo.shikimori.mvi.MviViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class AnimeDetailsViewModel @AssistedInject constructor(
    featureBuilder: AnimeDetailsFeatureBuilder,
): MviViewModel<AnimeDetailsAction, AnimeDetailsState, AnimeDetailsOneTimeEvent>(
    featureBuilder = featureBuilder
) {
    @AssistedFactory
    interface Factory {
        fun create(): AnimeDetailsViewModel
    }
}
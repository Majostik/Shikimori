package com.majo.shikimori.anime_details

import com.majo.shikimori.anime_details.mvi.AnimeDetailsFeatureBuilder
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsOneTimeEvent
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsState
import com.majo.shikimori.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    featureBuilder: AnimeDetailsFeatureBuilder,
) : MviViewModel<AnimeDetailsAction, AnimeDetailsState, AnimeDetailsOneTimeEvent>(
    featureBuilder = featureBuilder,
)

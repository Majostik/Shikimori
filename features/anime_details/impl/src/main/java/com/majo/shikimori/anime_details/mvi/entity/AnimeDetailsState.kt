package com.majo.shikimori.anime_details.mvi.entity

import com.majo.anime_details.model.AnimeDetails
import com.majo.shikimori.core.LoadableState

data class AnimeDetailsState(
    val data: LoadableState<AnimeDetails>,
) {
    companion object {
        val INITIAL = AnimeDetailsState(
            LoadableState.Loading(),
        )
    }
}

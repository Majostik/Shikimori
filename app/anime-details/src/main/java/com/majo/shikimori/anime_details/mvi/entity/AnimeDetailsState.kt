package com.majo.shikimori.anime_details.mvi.entity

import com.majo.anime_details.model.AnimeDetails

data class AnimeDetailsState(
    val animeDetails: AnimeDetails?,
) {
    companion object {
        val INITIAL = AnimeDetailsState(
            null
        )
    }
}
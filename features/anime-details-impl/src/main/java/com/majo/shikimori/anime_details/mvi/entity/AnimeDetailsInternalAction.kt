package com.majo.shikimori.anime_details.mvi.entity

import com.majo.anime_details.model.AnimeDetails

sealed interface AnimeDetailsInternalAction {
    object AnimeLoading: AnimeDetailsInternalAction
    data class AnimeError(val error: String): AnimeDetailsInternalAction
    data class AnimeLoaded(val anime: AnimeDetails): AnimeDetailsInternalAction
    object Close : AnimeDetailsInternalAction
}
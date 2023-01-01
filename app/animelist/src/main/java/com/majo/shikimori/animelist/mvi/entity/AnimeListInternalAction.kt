package com.majo.shikimori.animelist.mvi.entity

import android.content.Intent
import com.majo.shikimori.animelist.model.Anime

sealed interface AnimeListInternalAction {
    object FirstAnimeLoading: AnimeListInternalAction
    object AnimeLoading: AnimeListInternalAction
    data class AnimeError(val error: String): AnimeListInternalAction
    data class AnimeLoaded(val anime: List<Anime>): AnimeListInternalAction

    data class OpenScreen(val intent: Intent): AnimeListInternalAction
}
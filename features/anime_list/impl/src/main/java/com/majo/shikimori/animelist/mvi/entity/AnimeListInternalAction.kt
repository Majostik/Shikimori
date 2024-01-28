package com.majo.shikimori.animelist.mvi.entity

import com.majo.shikimori.animelist.model.Anime

sealed interface AnimeListInternalAction {
    object FirstAnimeLoading: AnimeListInternalAction
    object AnimeLoading: AnimeListInternalAction
    data class AnimeError(val error: String): AnimeListInternalAction
    data class AnimeLoaded(val anime: List<Anime>, val query: String? = null): AnimeListInternalAction

    data class OpenScreen(val id: Long, val name: String?): AnimeListInternalAction

    object Clear: AnimeListInternalAction
}
package com.majo.shikimori.animelist.mvi.entity

import com.majo.shikimori.animelist.model.Anime

data class AnimeListState(
    val animeList: List<Anime>,
    val page: Int,
    val isLoading: Boolean,
) {
    companion object {
        val INITIAL = AnimeListState(
            animeList = emptyList(),
            page = 1,
            isLoading = false,
        )
    }
}
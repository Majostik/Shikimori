package com.majo.shikimori.animelist.mvi.entity

sealed interface AnimeListAction {
    object Retry: AnimeListAction
    data class LoadNextPage(val page: Int): AnimeListAction
    data class OpenAnimeDetailsScreen(val id: Long): AnimeListAction
}
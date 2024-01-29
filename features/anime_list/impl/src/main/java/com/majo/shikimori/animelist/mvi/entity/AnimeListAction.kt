package com.majo.shikimori.animelist.mvi.entity

sealed interface AnimeListAction {

    data object Retry : AnimeListAction
    data object Init : AnimeListAction
    data class Search(val query: String? = null) : AnimeListAction
    data class LoadNextPage(val page: Int) : AnimeListAction
    data class OpenAnimeDetailsScreen(val id: Long, val name: String?) : AnimeListAction
}

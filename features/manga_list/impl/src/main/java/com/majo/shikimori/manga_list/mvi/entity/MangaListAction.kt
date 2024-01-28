package com.majo.shikimori.manga_list.mvi.entity

sealed interface MangaListAction {

    data object Init: MangaListAction
    data object Retry: MangaListAction

    data class Search(val query: String? = null): MangaListAction

    data class LoadNextPage(val page: Int): MangaListAction
}
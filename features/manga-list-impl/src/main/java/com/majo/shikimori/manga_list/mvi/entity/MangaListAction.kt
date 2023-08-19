package com.majo.shikimori.manga_list.mvi.entity

sealed interface MangaListAction {
    object Retry: MangaListAction
    data class LoadNextPage(val page: Int): MangaListAction
}
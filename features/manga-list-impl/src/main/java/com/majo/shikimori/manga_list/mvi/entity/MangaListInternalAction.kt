package com.majo.shikimori.manga_list.mvi.entity

import com.majo.shikimori.manga_list.model.Manga

sealed interface MangaListInternalAction {
    object FirstMangaLoading: MangaListInternalAction
    object MangaLoading: MangaListInternalAction
    data class MangaError(val error: String): MangaListInternalAction
    data class MangaLoaded(val mangas: List<Manga>): MangaListInternalAction

    data class OpenScreen(val id: Long, val name: String?): MangaListInternalAction
}
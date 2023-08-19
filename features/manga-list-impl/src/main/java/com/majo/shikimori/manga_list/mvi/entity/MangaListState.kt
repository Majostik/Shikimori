package com.majo.shikimori.manga_list.mvi.entity

import com.majo.shikimori.manga_list.model.Manga

data class MangaListState(
    val mangaList: List<Manga>,
    val page: Int,
    val isLoading: Boolean,
) {
    companion object {
        val INITIAL = MangaListState(
            mangaList = emptyList(),
            page = 1,
            isLoading = false,
        )
    }
}
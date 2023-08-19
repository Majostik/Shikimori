package com.majo.shikimori.manga_list.mvi.entity


sealed interface MangaListOneTimeEvent {
    class ShowError(val error: String): MangaListOneTimeEvent
}
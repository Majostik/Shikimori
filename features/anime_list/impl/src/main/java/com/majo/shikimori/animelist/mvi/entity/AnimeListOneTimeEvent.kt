package com.majo.shikimori.animelist.mvi.entity

sealed interface AnimeListOneTimeEvent {
    class OpenScreen(val id: Long, val name: String?) : AnimeListOneTimeEvent
    class ShowError(val error: String) : AnimeListOneTimeEvent
}

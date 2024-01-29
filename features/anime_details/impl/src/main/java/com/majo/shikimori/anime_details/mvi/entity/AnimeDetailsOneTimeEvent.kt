package com.majo.shikimori.anime_details.mvi.entity

sealed interface AnimeDetailsOneTimeEvent {
    object Close : AnimeDetailsOneTimeEvent
    class ShowError(val error: String) : AnimeDetailsOneTimeEvent
}

package com.majo.shikimori.anime_details.mvi.entity

sealed interface AnimeDetailsAction {
    data class LoadData(val id: Long) : AnimeDetailsAction
    data object Back : AnimeDetailsAction
}

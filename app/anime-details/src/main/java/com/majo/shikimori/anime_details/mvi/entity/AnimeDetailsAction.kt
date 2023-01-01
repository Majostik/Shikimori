package com.majo.shikimori.anime_details.mvi.entity

sealed interface AnimeDetailsAction {
    object LoadData: AnimeDetailsAction
    object Back: AnimeDetailsAction
}
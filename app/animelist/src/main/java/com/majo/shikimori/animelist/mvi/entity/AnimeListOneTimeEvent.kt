package com.majo.shikimori.animelist.mvi.entity

import android.content.Intent

sealed interface AnimeListOneTimeEvent {
    class OpenScreen(val intent: Intent): AnimeListOneTimeEvent
    class ShowError(val error: String): AnimeListOneTimeEvent
}
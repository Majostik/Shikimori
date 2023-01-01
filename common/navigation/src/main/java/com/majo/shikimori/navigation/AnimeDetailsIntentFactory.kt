package com.majo.shikimori.navigation

import android.content.Intent

interface AnimeDetailsIntentFactory {

    fun animeDetailsIntent(id: Long): Intent

}
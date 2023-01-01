package com.majo.shikimori.anime_details

import android.content.Context
import android.content.Intent
import com.majo.shikimori.navigation.AnimeDetailsIntentFactory
import javax.inject.Inject

class AnimeListDetailsFactoryImpl @Inject constructor(
    private val context: Context
): AnimeDetailsIntentFactory {
    override fun animeDetailsIntent(id: Long): Intent {
        return AnimeDetailsActivity.createIntent(context, id)
    }
}
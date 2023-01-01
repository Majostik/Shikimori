package com.majo.shikimori.animelist

import android.content.Context
import android.content.Intent
import com.majo.shikimori.navigation.AnimeListIntentFactory
import javax.inject.Inject

class AnimeListIntentFactoryImpl @Inject constructor(
    private val context: Context
): AnimeListIntentFactory {
    override fun animeListIntent(): Intent {
        return AnimeListActivity.createIntent(context)
    }
}
package com.majo.shikimori.anime_details

import android.content.Context
import android.content.Intent
import com.majo.shikimori.dagger.anvil.AppScope
import com.majo.shikimori.navigation.AnimeDetailsIntentFactory
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class AnimeDetailsFactoryImpl @Inject constructor(
    private val context: Context
): AnimeDetailsIntentFactory {
    override fun animeDetailsIntent(id: Long, name: String?): Intent {
        return AnimeDetailsActivity.createIntent(context, AnimeDetailsArgs(id, name))
    }
}
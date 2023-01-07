package com.majo.shikimori.animelist

import android.content.Context
import android.content.Intent
import com.majo.shikimori.dagger.anvil.ActivityScope
import com.majo.shikimori.dagger.anvil.AppScope
import com.majo.shikimori.navigation.AnimeListIntentFactory
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.ContributesTo
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class AnimeListIntentFactoryImpl @Inject constructor(
    private val context: Context
): AnimeListIntentFactory {
    override fun animeListIntent(): Intent {
        return AnimeListActivity.createIntent(context)
    }
}
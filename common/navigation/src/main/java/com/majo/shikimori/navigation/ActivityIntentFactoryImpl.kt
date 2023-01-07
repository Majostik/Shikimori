package com.majo.shikimori.navigation

import com.majo.shikimori.dagger.anvil.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(
    scope = AppScope::class,
    boundType = ActivityIntentFactory::class
)
class ActivityIntentFactoryImpl @Inject constructor(
    animeListIntentFactory: AnimeListIntentFactory,
    animeDetailsIntentFactory: AnimeDetailsIntentFactory
): ActivityIntentFactory,
    AnimeListIntentFactory by animeListIntentFactory,
    AnimeDetailsIntentFactory by animeDetailsIntentFactory
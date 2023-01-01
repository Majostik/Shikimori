package com.majo.shikimori.navigation

import javax.inject.Inject

class ActivityIntentFactoryImpl @Inject constructor(
    animeListIntentFactory: AnimeListIntentFactory,
    animeDetailsIntentFactory: AnimeDetailsIntentFactory
): ActivityIntentFactory,
    AnimeListIntentFactory by animeListIntentFactory,
    AnimeDetailsIntentFactory by animeDetailsIntentFactory
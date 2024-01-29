package com.majo.shikimori.anime_details.mvi

import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsInternalAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsOneTimeEvent
import com.majo.shikimori.mvi.OneTimeEventProducer
import javax.inject.Inject

class AnimeDetailsOneTimeEventReducer @Inject constructor() : OneTimeEventProducer<AnimeDetailsInternalAction, AnimeDetailsOneTimeEvent> {
    override fun produce(internalAction: AnimeDetailsInternalAction): AnimeDetailsOneTimeEvent? {
        return when (internalAction) {
            is AnimeDetailsInternalAction.Close -> AnimeDetailsOneTimeEvent.Close
            is AnimeDetailsInternalAction.AnimeError -> AnimeDetailsOneTimeEvent.ShowError(internalAction.error)
            else -> null
        }
    }
}

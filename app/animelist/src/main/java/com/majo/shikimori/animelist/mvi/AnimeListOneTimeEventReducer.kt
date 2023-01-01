package com.majo.shikimori.animelist.mvi

import com.majo.shikimori.animelist.mvi.entity.AnimeListInternalAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListOneTimeEvent
import com.majo.shikimori.mvi.OneTimeEventProducer
import javax.inject.Inject

class AnimeListOneTimeEventReducer @Inject constructor(
): OneTimeEventProducer<AnimeListInternalAction, AnimeListOneTimeEvent> {
    override fun produce(internalAction: AnimeListInternalAction): AnimeListOneTimeEvent? {
        return when(internalAction) {
            is AnimeListInternalAction.AnimeError -> AnimeListOneTimeEvent.ShowError(internalAction.error)
            is AnimeListInternalAction.OpenScreen -> AnimeListOneTimeEvent.OpenScreen(internalAction.intent)
            else -> null
        }
    }
}
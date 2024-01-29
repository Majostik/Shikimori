package com.majo.shikimori.manga_list.mvi

import com.majo.shikimori.manga_list.mvi.entity.MangaListInternalAction
import com.majo.shikimori.manga_list.mvi.entity.MangaListOneTimeEvent
import com.majo.shikimori.mvi.OneTimeEventProducer
import javax.inject.Inject

class MangaListOneTimeEventReducer @Inject constructor() : OneTimeEventProducer<MangaListInternalAction, MangaListOneTimeEvent> {
    override fun produce(internalAction: MangaListInternalAction): MangaListOneTimeEvent? {
        return when (internalAction) {
            is MangaListInternalAction.MangaError -> MangaListOneTimeEvent.ShowError(internalAction.error)
            else -> null
        }
    }
}

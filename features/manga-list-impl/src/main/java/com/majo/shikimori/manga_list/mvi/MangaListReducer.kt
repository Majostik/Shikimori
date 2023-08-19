package com.majo.shikimori.manga_list.mvi

import com.majo.shikimori.manga_list.mvi.entity.MangaListInternalAction
import com.majo.shikimori.manga_list.mvi.entity.MangaListState
import com.majo.shikimori.mvi.Reducer
import javax.inject.Inject

class MangaListReducer @Inject constructor(): Reducer<MangaListInternalAction, MangaListState> {
    override fun reduce(
        internalAction: MangaListInternalAction,
        previousState: MangaListState
    ): MangaListState {
        return when(internalAction) {
            is MangaListInternalAction.MangaLoaded -> {
                previousState.copy(
                    mangaList = previousState.mangaList + internalAction.mangas,
                    page = previousState.page + 1,
                    isLoading = false
                )
            }
            is MangaListInternalAction.MangaLoading, is MangaListInternalAction.FirstMangaLoading -> {
                previousState.copy(isLoading = true)
            }
            is MangaListInternalAction.MangaError -> {
                previousState.copy(isLoading = false)
            }
            else -> previousState
        }
    }
}
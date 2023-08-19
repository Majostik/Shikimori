package com.majo.shikimori.manga_list

import com.majo.shikimori.manga_list.mvi.MangaListFeatureBuilder
import com.majo.shikimori.manga_list.mvi.entity.MangaListAction
import com.majo.shikimori.manga_list.mvi.entity.MangaListOneTimeEvent
import com.majo.shikimori.manga_list.mvi.entity.MangaListState
import com.majo.shikimori.mvi.MviViewModel
import javax.inject.Inject

class MangaListViewModel @Inject constructor(
    featureBuilder: MangaListFeatureBuilder,
): MviViewModel<MangaListAction, MangaListState, MangaListOneTimeEvent>(
    featureBuilder = featureBuilder
)
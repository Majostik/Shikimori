package com.majo.shikimori.anime_details.mvi

import com.majo.shikimori.anime_details.AnimeDetailsInteractor
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsInternalAction
import com.majo.shikimori.mvi.Bootstrap
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeDetailsBootstrap @Inject constructor(
    private val interactor: AnimeDetailsInteractor,
    private val id: Long
) : Bootstrap<AnimeDetailsInternalAction>{

    override fun produce(): Flow<AnimeDetailsInternalAction> {
        return interactor.getAnimeDetails(id)
    }

}
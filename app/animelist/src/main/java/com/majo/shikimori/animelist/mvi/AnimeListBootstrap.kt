package com.majo.shikimori.animelist.mvi

import com.majo.shikimori.animelist.AnimeListInteractor
import com.majo.shikimori.animelist.mvi.entity.AnimeListInternalAction
import com.majo.shikimori.mvi.Bootstrap
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeListBootstrap @Inject constructor(
    private val interactor: AnimeListInteractor
) : Bootstrap<AnimeListInternalAction>{
    override fun produce(): Flow<AnimeListInternalAction> {
        return interactor.loadAnime(1, 20)
    }

}
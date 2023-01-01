package com.majo.shikimori.anime_details

import com.majo.anime_details.AnimeDetailsApi
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsInternalAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AnimeDetailsInteractor {
    fun getAnimeDetails(id: Long): Flow<AnimeDetailsInternalAction>
}

class AnimeDetailsInteractorImpl @Inject constructor(
    private val animeDetailsApi: AnimeDetailsApi
): AnimeDetailsInteractor {
    override fun getAnimeDetails(id: Long): Flow<AnimeDetailsInternalAction> {
        return flow {
            emit(AnimeDetailsInternalAction.AnimeLoading)
            try {
                val anime = animeDetailsApi.getAnimeDetails(id)
                emit(AnimeDetailsInternalAction.AnimeLoaded(anime))
            } catch (e: Exception) {
                emit(AnimeDetailsInternalAction.AnimeError(error = e.message.toString()))
            }
        }
    }
}
package com.majo.shikimori.anime_details

import com.majo.anime_details.AnimeDetailsApi
import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsInternalAction
import com.majo.shikimori.dagger.PerScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AnimeDetailsInteractor {
    fun getAnimeDetails(id: Long): Flow<AnimeDetailsInternalAction>
}

class AnimeDetailsInteractorImpl @Inject constructor(
    private val animeDetailsApi: AnimeDetailsApi,
    private val errorConverter: ErrorConverter
): AnimeDetailsInteractor {
    override fun getAnimeDetails(id: Long): Flow<AnimeDetailsInternalAction> {
        return flow {
            emit(AnimeDetailsInternalAction.AnimeLoading)
            val anime = animeDetailsApi.getAnimeDetails(id)
            emit(AnimeDetailsInternalAction.AnimeLoaded(anime))
        }.catch {
            emit(AnimeDetailsInternalAction.AnimeError(error = errorConverter.convertError(it)))
        }
    }
}
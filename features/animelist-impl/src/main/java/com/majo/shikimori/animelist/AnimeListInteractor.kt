package com.majo.shikimori.animelist

import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.animelist.mvi.AnimeListActor.Companion.INIT_PAGE
import com.majo.shikimori.animelist.mvi.entity.AnimeListInternalAction
import com.majo.shikimori.anvil.ScreenScope
import com.majo.shikimori.dagger.PerScreen
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AnimeListInteractor {
    fun loadAnime(page: Int, limit: Int, query: String? = null): Flow<AnimeListInternalAction>
}

@ContributesBinding(ScreenScope::class)
@PerScreen
class AnimeListInteractorImpl @Inject constructor(
    private val animeListApi: AnimeListApi,
    private val errorConverter: ErrorConverter
): AnimeListInteractor {
    override fun loadAnime(page: Int, limit: Int, query : String?): Flow<AnimeListInternalAction> {
        return flow {
            if (page == INIT_PAGE) {
                emit(AnimeListInternalAction.FirstAnimeLoading)
            } else {
                emit(AnimeListInternalAction.AnimeLoading)
            }
            val list = animeListApi.getAnimes(page, limit, query)
            emit(AnimeListInternalAction.AnimeLoaded(list, query))
        }.catch {
            emit(AnimeListInternalAction.AnimeError(error = errorConverter.convertError(it)))
        }
    }

}
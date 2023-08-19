package com.majo.shikimori.animelist

import com.majo.shikimori.animelist.mvi.AnimeListActor.Companion.INIT_PAGE
import com.majo.shikimori.animelist.mvi.entity.AnimeListInternalAction
import com.majo.shikimori.dagger.PerActivity
import com.majo.shikimori.dagger.PerScreen
import com.majo.shikimori.dagger.anvil.ActivityScope
import com.majo.shikimori.dagger.anvil.ScreenScope
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AnimeListInteractor {
    fun loadAnime(page: Int, limit: Int): Flow<AnimeListInternalAction>
}

@ContributesBinding(ScreenScope::class)
@PerScreen
class AnimeListInteractorImpl @Inject constructor(
    private val animeListApi: AnimeListApi
): AnimeListInteractor {
    override fun loadAnime(page: Int, limit: Int): Flow<AnimeListInternalAction> {
        return flow {
            if (page == INIT_PAGE) {
                emit(AnimeListInternalAction.FirstAnimeLoading)
            } else {
                emit(AnimeListInternalAction.AnimeLoading)
            }
            try {
                val list = animeListApi.getAnimes(page, limit)
                emit(AnimeListInternalAction.AnimeLoaded(list))
            } catch (e: Exception) {
                emit(AnimeListInternalAction.AnimeError(error = e.message.toString()))
            }
        }
    }

}
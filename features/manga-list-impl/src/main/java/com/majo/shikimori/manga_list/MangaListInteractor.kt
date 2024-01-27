package com.majo.shikimori.manga_list

import com.majo.shikimori.android.ErrorConverter
import com.majo.shikimori.manga_list.mvi.MangaListActor.Companion.INIT_PAGE
import com.majo.shikimori.manga_list.mvi.entity.MangaListInternalAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface MangaListInteractor {
    fun loadManga(page: Int, limit: Int, query: String? = null): Flow<MangaListInternalAction>
}

class MangaListInteractorImpl @Inject constructor(
    private val aangaListApi: MangaListApi,
    private val errorConverter: ErrorConverter
): MangaListInteractor {
    override fun loadManga(page: Int, limit: Int, query: String?): Flow<MangaListInternalAction> {
        return flow {
            if (page == INIT_PAGE) {
                emit(MangaListInternalAction.FirstMangaLoading)
            } else {
                emit(MangaListInternalAction.MangaLoading)
            }
            val list = aangaListApi.getMangas(page, limit, query)
            emit(MangaListInternalAction.MangaLoaded(list))
        }.catch {
            emit(MangaListInternalAction.MangaError(error = errorConverter.convertError(it)))
        }
    }

}
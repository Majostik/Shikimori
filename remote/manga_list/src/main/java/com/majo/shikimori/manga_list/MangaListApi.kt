package com.majo.shikimori.manga_list

import com.majo.shikimori.manga_list.model.Manga
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaListApi {

    @GET("mangas")
    suspend fun getMangas(@Query("page") page: Int, @Query("limit") limit: Int, @Query("search") search: String?): List<Manga>
}

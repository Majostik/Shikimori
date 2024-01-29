package com.majo.shikimori.animelist

import com.majo.shikimori.animelist.model.Anime
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeListApi {

    @GET("animes")
    suspend fun getAnimes(@Query("page") page: Int, @Query("limit") limit: Int, @Query("search ") search: String?): List<Anime>
}

package com.majo.shikimori.animelist

import com.majo.shikimori.animelist.model.Anime
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeListApi {

    @GET("animes")
    suspend fun getAnimes(@Query("limit") limit: Int = 20): List<Anime>
}
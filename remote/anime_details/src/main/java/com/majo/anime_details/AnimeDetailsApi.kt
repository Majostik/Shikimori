package com.majo.anime_details

import com.majo.anime_details.model.AnimeDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeDetailsApi {

    @GET("animes/{id}")
    suspend fun getAnimeDetails(@Path("id") id: Long): AnimeDetails
}
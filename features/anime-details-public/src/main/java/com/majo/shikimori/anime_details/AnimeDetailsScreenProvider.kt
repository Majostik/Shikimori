package com.majo.shikimori.anime_details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface AnimeDetailsScreenProvider {

    fun animeDetailsScreen(name: String?, id: Long): String

    fun registerAnimeDetailsScreen(navGraphBuilder: NavGraphBuilder, navController: NavHostController)
}
package com.majo.shikimori.animelist_public

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface AnimeListScreenProvider {

    fun animeListScreen(navGraphBuilder: NavGraphBuilder, navController: NavHostController)
}

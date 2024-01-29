package com.majo.shikimori.manga_list

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface MangaListScreenProvider {

    fun mangaListScreen(navGraphBuilder: NavGraphBuilder, navController: NavHostController)
}

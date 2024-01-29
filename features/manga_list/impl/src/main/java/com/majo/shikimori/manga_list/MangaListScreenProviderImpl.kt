package com.majo.shikimori.manga_list

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.majo.shikimori.navigation.NavigationItem
import javax.inject.Inject

class MangaListScreenProviderImpl @Inject constructor() : MangaListScreenProvider {

    override fun mangaListScreen(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
    ) {
        navGraphBuilder.composable(NavigationItem.MangaList.route) {
            MangaListScreen(navController)
        }
    }
}

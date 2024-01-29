package com.majo.shikimori.animelist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.majo.shikimori.anime_details.AnimeDetailsScreenProvider
import com.majo.shikimori.animelist_public.AnimeListScreenProvider
import com.majo.shikimori.navigation.NavigationItem
import javax.inject.Inject

class AnimeListScreenProviderImpl @Inject constructor(
    private val animeDetailsScreenProvider: AnimeDetailsScreenProvider,
) : AnimeListScreenProvider {

    override fun animeListScreen(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
        navGraphBuilder.composable(NavigationItem.AnimeList.route) {
            AnimeListScreen(navController)
        }

        animeDetailsScreenProvider.registerAnimeDetailsScreen(navGraphBuilder, navController)
    }
}

package com.majo.shikimori.anime_details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import javax.inject.Inject

class AnimeDetailsScreenProviderImpl @Inject constructor() : AnimeDetailsScreenProvider {

    private val screen = "animeDetails"

    override fun animeDetailsScreen(name: String?, id: Long): String = "$screen/$name/$id"

    override fun registerAnimeDetailsScreen(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
        navGraphBuilder.composable("$screen/{name}/{id}") {
            val name = it.arguments?.getString("name")
            val id = it.arguments?.getString("id")?.toLongOrNull()
            if (name != null && id != null) {
                AnimeDetailsScreen(navController = navController, args = AnimeDetailsArgs(id = id, name = name))
            }
        }
    }
}

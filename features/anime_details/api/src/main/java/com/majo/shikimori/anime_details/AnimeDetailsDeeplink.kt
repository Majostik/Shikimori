package com.majo.shikimori.anime_details

import androidx.navigation.NavController
import com.majo.shikimori.navigation.Deeplink

object AnimeDetailsDeeplink : Deeplink {
    override val screen: String
        get() = "animeDetails"

    fun NavController.navigateToAnimeDetailsScreen(name: String?, id: Long) {
        this.navigate("$screen/${name}/${id}")
    }

}
package com.majo.shikimori.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object AnimeList : NavigationItem("Anime", Icons.Rounded.List, "Anime")
    object MangaList : NavigationItem("Manga", Icons.Rounded.List, "Manga")
}

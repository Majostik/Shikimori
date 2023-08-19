package com.majo.shikimori.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.majo.shikimori.animelist_public.AnimeListScreenProvider
import com.majo.shikimori.compose.ShikimoriTheme
import com.majo.shikimori.dagger.findComponentDependencies
import com.majo.shikimori.home.di.DaggerHomeListComponent
import com.majo.shikimori.manga_list.MangaListScreenProvider
import com.majo.shikimori.navigation.NavigationItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val homeComponent = DaggerHomeListComponent.factory().create(context.findComponentDependencies())
    val animeListScreenProvider = homeComponent.animeListScreenProvider()
    val mangaListScreenProvider = homeComponent.mangaListScreenProvider()
    val navController = rememberNavController()

    ShikimoriTheme {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    modifier = Modifier
                        .height(56.dp),
                    navController
                )
            }
        ) { paddingValues ->
            HomeScreenNavigationConfigurations(
                navController,
                animeListScreenProvider,
                mangaListScreenProvider,
                paddingValues)
        }
    }
}

@Composable
private fun HomeScreenNavigationConfigurations(
    navController: NavHostController,
    animeListScreenProvider: AnimeListScreenProvider,
    mangaListScreenProvider: MangaListScreenProvider,
    paddingValues: PaddingValues
) {
    Column(modifier = Modifier.padding(paddingValues)) {
        NavHost(
            navController = navController,
            startDestination = NavigationItem.AnimeList.route
        ) {
            animeListScreenProvider.animeListScreen(this, navController)
            mangaListScreenProvider.mangaListScreen(this, navController)
        }
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier, navController: NavController) {
    val bottomNavigationItems = listOf(
        NavigationItem.AnimeList,
        NavigationItem.MangaList,
    )
    NavigationBar(
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        bottomNavigationItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.route) },
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }

                        /**
                         * As per https://developer.android.com/jetpack/compose/navigation#bottom-nav
                         * By using the saveState and restoreState flags,
                         * the state and back stack of that item is correctly saved
                         * and restored as you swap between bottom navigation items.
                         */

                        /**
                         * As per https://developer.android.com/jetpack/compose/navigation#bottom-nav
                         * By using the saveState and restoreState flags,
                         * the state and back stack of that item is correctly saved
                         * and restored as you swap between bottom navigation items.
                         */

                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true

                        // Restore state when reselecting a previously selected item
                        restoreState = true

                    }
                }
            )
        }
    }
}
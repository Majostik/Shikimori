package com.majo.shikimori.home

import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.majo.shikimori.animelist_public.AnimeListScreenProvider
import com.majo.shikimori.compose.ShikimoriTheme
import com.majo.shikimori.dagger.findComponentDependencies
import com.majo.shikimori.home.di.DaggerHomeListComponent
import com.majo.shikimori.manga_list.MangaListScreenProvider
import com.majo.shikimori.navigation.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val homeComponent = DaggerHomeListComponent.factory().create(context.findComponentDependencies())
    val animeListScreenProvider = homeComponent.animeListScreenProvider()
    val mangaListScreenProvider = homeComponent.mangaListScreenProvider()
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val isLight = !isSystemInDarkTheme()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    SideEffect {
        systemUiController.run {
            setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = isLight
            )
        }
    }

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        NavigationItem.AnimeList.route -> true
        NavigationItem.MangaList.route -> true
        else -> false
    }

    ShikimoriTheme {
        Scaffold(
            bottomBar = {
                if (showBottomBar)
                    BottomNavigationBar(
                        modifier = Modifier
                            .height(76.dp),
                        navController
                    )
            }
        ) { paddingValues ->
            HomeScreenNavigationConfigurations(
                navController,
                animeListScreenProvider,
                mangaListScreenProvider,
                paddingValues
            )
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
        modifier = modifier,
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
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
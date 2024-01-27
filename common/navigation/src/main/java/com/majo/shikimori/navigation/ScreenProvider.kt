package com.majo.shikimori.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface ScreenProvider {
    fun register(navGraphBuilder: NavGraphBuilder, navController: NavHostController)

}
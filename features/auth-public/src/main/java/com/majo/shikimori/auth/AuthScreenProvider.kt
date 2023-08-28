package com.majo.shikimori.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface AuthScreenProvider {

    fun authScreen(navGraphBuilder: NavGraphBuilder, navController: NavHostController)
}
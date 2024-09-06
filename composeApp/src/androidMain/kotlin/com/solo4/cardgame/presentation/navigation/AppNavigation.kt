package com.solo4.cardgame.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.solo4.cardgame.presentation.screens.menu.MenuScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, Route.Menu::class) {
        composable<Route.Menu> {
            MenuScreen(navController)
        }
    }
}
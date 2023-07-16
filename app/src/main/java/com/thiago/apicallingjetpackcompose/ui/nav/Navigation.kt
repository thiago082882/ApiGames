package com.thiago.apicallingjetpackcompose.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thiago.apicallingjetpackcompose.ui.screens.DetailScreen
import com.thiago.apicallingjetpackcompose.ui.screens.HomeScreen
import com.thiago.apicallingjetpackcompose.ui.vm.GameViewModel
import com.thiago.apicallingjetpackcompose.util.Constants.Companion.KEY_GAME_ID
import com.thiago.apicallingjetpackcompose.util.Constants.Screens.DETAIL_SCREEN
import com.thiago.apicallingjetpackcompose.util.Constants.Screens.HOME_SCREEN

sealed class Screens (val route: String){

    object Home: Screens(route = HOME_SCREEN)

    object Detail: Screens(route = DETAIL_SCREEN)

}

@Composable
fun SetupNavHost(navController: NavHostController, gameViewModel: GameViewModel) {

    NavHost(navController = navController, startDestination = Screens.Home.route) {

        composable(route = Screens.Home.route) {
            HomeScreen(gameViewModel = gameViewModel, navController = navController)
        }

        composable(route = Screens.Detail.route + "/{$KEY_GAME_ID}") { backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getString(KEY_GAME_ID)?: "1", gameViewModel = gameViewModel, navController = navController)
        }

    }

}
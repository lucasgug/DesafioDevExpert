package com.lucasgugliuzza.desafiodevexpert.presentation.Screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucasgugliuzza.desafiodevexpert.presentation.viewModel.MovieViewModel
import kotlinx.coroutines.delay

@Composable
fun Navigation(
    movieviewModel: MovieViewModel
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.SplashScreen.route) {
            SplashScreen()

            LaunchedEffect(key1 = null){
                delay(3000)

                navController.popBackStack() //permite no volver al SlashScreen estando en el home

                navController.navigate(Screen.HomeScreen.route)
            }
        }

        composable(Screen.HomeScreen.route) {
            HomeScreen(movieviewModel = movieviewModel)

        }
    }
}


sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object HomeScreen : Screen("home_screen")
}
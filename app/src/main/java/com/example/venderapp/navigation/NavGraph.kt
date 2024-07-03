package com.example.venderapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.venderapp.HomeScreen.Home
import com.example.venderapp.Screens.SignUpPage.SignUpScreen
import com.example.venderapp.Screens.SignUpPage.SignUpScreenViewModel


@Composable
fun NavGraph(signUpScreenViewModel: SignUpScreenViewModel, navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Routes.Home) {

        composable<Routes.SignUpScreen> {
            SignUpScreen(signUpScreenViewModel, navHostController = navHostController)
        }

        composable<Routes.Home> {
            Home(navHostController = navHostController)
        }
    }
}
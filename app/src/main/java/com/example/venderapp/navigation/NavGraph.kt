package com.example.venderapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.venderapp.screen.HomeScreen
import com.example.venderapp.screen.SignUpScreen
import com.example.venderapp.viewmodel.VendorViewModel


@Composable
fun NavGraph(vendorViewModel: VendorViewModel, navHostController: NavHostController) {

    val userId by vendorViewModel.userId.collectAsState()
    LaunchedEffect(key1 = userId) {
        if (userId != 0) {
            navHostController.navigate(Routes.HomeScreen) {
                popUpTo(Routes.SignUpScreen) { inclusive = true }
            }
        }
    }

    NavHost(
        navController = navHostController,
        startDestination = Routes.SignUpScreen
    ) {

        composable<Routes.SignUpScreen> {
            SignUpScreen(vendorViewModel = vendorViewModel, navHostController = navHostController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(vendorViewModel = vendorViewModel, navHostController = navHostController)
        }
    }

}
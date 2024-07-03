package com.example.venderapp.HomeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(navHostController: NavHostController) {
    Scaffold (
        bottomBar = {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = BottomNavNavigation.DashBoard) {

                composable<BottomNavNavigation.DashBoard> {
                    Text(text = "Sheet 1")
                }
                composable<BottomNavNavigation.Sell> {
                    Text(text = "Sheet 2")
                }
                composable<BottomNavNavigation.Inventory> {
                    Text(text = "Sheet 3")
                }
                composable<BottomNavNavigation.Profile> {
                    Text(text = "Sheet 4")
                }
            }
        }
    ){
        Box (modifier = Modifier.padding(it).fillMaxSize()){

        }
    }
}
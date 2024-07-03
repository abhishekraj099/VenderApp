package com.example.venderapp.HomeScreen

import kotlinx.serialization.Serializable

sealed class BottomNavNavigation {
    @Serializable
    object DashBoard
    @Serializable
    object Sell
    @Serializable
    object Inventory
    @Serializable
    object Profile
}
package com.example.venderapp.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object Home
    @Serializable
    object SignUpScreen
    @Serializable
    object SignInScreen


}

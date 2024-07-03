package com.example.venderapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.venderapp.Screens.SignUpPage.SignUpScreenViewModel
import com.example.venderapp.navigation.NavGraph
import com.example.venderapp.ui.theme.VenderAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val signUpScreenViewModel: SignUpScreenViewModel by viewModels()
            val navHostController = rememberNavController()
            VenderAppTheme {
                Scaffold {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        NavGraph(
                            signUpScreenViewModel = signUpScreenViewModel,
                            navHostController = navHostController
                        )
                    }
                }
            }
        }
    }
}


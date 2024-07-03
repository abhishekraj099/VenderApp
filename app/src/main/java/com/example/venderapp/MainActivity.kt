package com.example.venderapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

import com.example.venderapp.navigation.NavGraph
import com.example.venderapp.pref.DataStoreManager
import com.example.venderapp.ui.theme.VenderAppTheme
import com.example.venderapp.viewmodel.VendorViewModel
import com.example.venderapp.viewmodel.VendorViewModelFactory


class MainActivity : ComponentActivity() {
    private val dataStoreManager by lazy { DataStoreManager(applicationContext) }
    private val vendorViewModel: VendorViewModel by viewModels {
        VendorViewModelFactory(dataStoreManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            VenderAppTheme {
                Scaffold {
                    Surface(modifier = Modifier.padding(it)) {
                        NavGraph(
                            vendorViewModel = vendorViewModel,
                            navHostController = navHostController
                        )
                    }
                }
            }
        }
    }
}


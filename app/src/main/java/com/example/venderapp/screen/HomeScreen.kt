package com.example.venderapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.example.venderapp.viewmodel.VendorViewModel


@Composable
fun HomeScreen(vendorViewModel: VendorViewModel, navHostController: NavHostController) {
    var selectedTab by remember { mutableStateOf(BottomNavigationItem.Dashboard) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .weight(0.95f)
            .fillMaxWidth()
        ) {
            when (selectedTab) {
                BottomNavigationItem.Dashboard -> Text("Dashboard")
                BottomNavigationItem.Sales -> Text("Sales")
                BottomNavigationItem.Orders -> Orders(vendorViewModel, navHostController)
                BottomNavigationItem.Profile -> Text("Profile")
            }
        }

        Row(
            modifier = Modifier
                .weight(0.05f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem.values().forEach { item ->
                IconButton(onClick = { selectedTab = item }) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.name,
                        tint = if (selectedTab == item) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
        }
    }
}

enum class BottomNavigationItem(val icon: ImageVector) {
    Dashboard(Icons.Rounded.Dashboard),
    Sales(Icons.Rounded.Money),
    Orders(Icons.Rounded.ShoppingCart),
    Profile(Icons.Rounded.Person)
}
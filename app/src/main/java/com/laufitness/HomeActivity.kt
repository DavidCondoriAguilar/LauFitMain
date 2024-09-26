package com.laufitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.laufitness.ui.theme.LauFitnessTheme

val BottomNavColor = Color(0xFFFF0000)

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LauFitnessTheme {
                val navController = rememberNavController()
                var selectedTab by remember { mutableStateOf("home") }

                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            backgroundColor = BottomNavColor,
                            contentColor = Color.White
                        ) {
                            val tabs = listOf(
                                BottomNavItem("Comunidad", Icons.Default.Home, "home"),
                                BottomNavItem("Nutrición", Icons.Default.Favorite, "nutrition"),
                                BottomNavItem("Entrenadores", Icons.Default.Face, "trainers")
                            )

                            tabs.forEach { tab ->
                                BottomNavigationItem(
                                    icon = { Icon(imageVector = tab.icon, contentDescription = null) },
                                    label = { Text(tab.label, color = Color.White) }, // Color del texto a blanco
                                    selected = selectedTab == tab.route,
                                    onClick = {
                                        selectedTab = tab.route
                                        navController.navigate(tab.route) {
                                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    selectedContentColor = Color.White,
                                    unselectedContentColor = Color.Gray
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        Modifier.padding(innerPadding)
                    ) {
                        composable("home") { ComunidadScreen() }
                        composable("nutrition") { NutritionScreen() }
                        composable("trainers") { TrainerScreen() }
                    }
                }
            }
        }
    }
}

data class BottomNavItem(val label: String, val icon: ImageVector, val route: String)

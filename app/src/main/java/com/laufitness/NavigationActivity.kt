package com.laufitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val Redd = Color(0xFFFF0000) // Color rojo

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            var selectedTab by remember { mutableStateOf("home") }

            Scaffold(
                bottomBar = {
                    BottomNavigationBar(selectedTab) { route ->
                        selectedTab = route
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    Modifier.padding(innerPadding)
                ) {
                    composable("home") { ComunidadScreen() } // Pantalla de Comunidad
                    composable("trainer") { TrainerScreen() } // Pantalla de Trainer
                    composable("workout") { NutritionScreen() } // Pantalla de Workout
                    // Agrega más pantallas según las tengas creadas
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(selectedTab: String, onTabSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Redd),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val tabs = listOf("home", "trainer", "workout", "categorias")
        val labels = listOf("Home", "Trainers", "Workout", "Category")
        val icons = listOf(Icons.Filled.Home, Icons.Filled.Star, Icons.Filled.PlayArrow, Icons.Filled.Person)

        tabs.forEachIndexed { index, route ->
            val isSelected = selectedTab == route
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onTabSelected(route) }
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = icons[index],
                    contentDescription = null,
                    tint = if (isSelected) Color.White else Color.Gray
                )
                Text(
                    text = labels[index],
                    color = if (isSelected) Color.White else Color.Gray,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}

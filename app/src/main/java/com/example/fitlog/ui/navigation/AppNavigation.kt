package com.example.fitlog.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.ShowChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    data object Dashboard : BottomNavItem("dashboard", "Dziś", Icons.Rounded.Home)
    data object Workout : BottomNavItem("workout", "Trening", Icons.Rounded.FitnessCenter)
    data object Diet : BottomNavItem("diet", "Dieta", Icons.Rounded.Restaurant)
    data object Progress : BottomNavItem("progress", "Progres", Icons.Rounded.ShowChart)
}

@Composable
fun MainAppShell() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem.Dashboard,
        BottomNavItem.Workout,
        BottomNavItem.Diet,
        BottomNavItem.Progress
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Dashboard.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Dashboard.route) {
                PlaceholderScreen("Dashboard — podsumowanie dnia, woda, suplementy, eksport MD")
            }
            composable(BottomNavItem.Workout.route) {
                PlaceholderScreen("Trening — siłownia i basen")
            }
            composable(BottomNavItem.Diet.route) {
                PlaceholderScreen("Dieta — bloki posiłków z godziną i baza posiłków")
            }
            composable(BottomNavItem.Progress.route) {
                PlaceholderScreen("Progres — wykresy wagi/obwodów i timelapse sylwetki")
            }
        }
    }
}

@Composable
private fun PlaceholderScreen(text: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = text, color = MaterialTheme.colorScheme.onBackground)
    }
}